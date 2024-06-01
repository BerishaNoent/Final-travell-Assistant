import React, { useState, useEffect } from "react";
import { Form, Button, InputGroup } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import ClipLoader from "react-spinners/ClipLoader";
import "./serachFlights.css";
import MySelect from "./MySelect.jsx";
import { MdGpsFixed } from "react-icons/md";
import { MdClear } from "react-icons/md";
import "../index.scss";
import { toast } from "react-toastify";
import {
  fetchAirports,
  getFlightResults,
  saveRecentSearch,
  getHotelResults,
  getCarRentalResults,
} from "../Api.js";

const SearchFlights = ({ userLoggedData }) => {
  const { token, userId } = userLoggedData;
  const [cityOptions, setCityOptions] = useState([]);
  const [origin, setOrigin] = useState(null);
  const [destination, setDestination] = useState(null);
  const [date, setDate] = useState("");
  const [returnTicket, setReturnTicket] = useState(false);
  const [returnOrigin, setReturnOrigin] = useState(null);
  const [returnDestination, setReturnDestination] = useState(null);
  const [returnDate, setReturnDate] = useState(null);
  const [adults, setAdults] = useState(1);
  const [children, setChildren] = useState(0);
  const [loading, setLoading] = useState(false);
  const [flightResults, setFlightResults] = useState([]);
  const [hotelResults, setHotelResults] = useState([]);
  const [carRentalResults, setCarRentalResults] = useState([]);
  const navigate = useNavigate();
  const [status, setStatus] = useState("");
  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const jsonDataa = await fetchAirports(token);
        const jsonData = jsonDataa.body;
        const newCityOptions = [];
        for (const country of jsonData) {
          const details = country.Cities;
          for (const city of details) {
            const airports =
              city.Airports.length > 0
                ? city.Airports
                : [{ Name: city.Airport, IATA_Code: city.IATA_Code }];
            airports.forEach((airport) => {
              if (airport.IATA_Code && airport.Name) {
                const option = {
                  id: airport.IATA_Code,
                  value: airport.IATA_Code,
                  label: `${city.Location} - ${airport.Name} (${airport.IATA_Code})`,
                  city: city.Location,
                  region: country.name,
                  airport: airport.Name,
                };
                newCityOptions.push(option);
              } else {
              }
            });
          }
        }
        setCityOptions(newCityOptions);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, []);

  const handleSubmit = async (event) => {
    event.preventDefault();
    setLoading(true);
    const formData = {
      origin: origin ? origin.value : null,
      destination: destination ? destination.value : null,
      destinationName: destination ? destination.city : null,
      originName: origin ? origin.city : null,
      country: destination ? destination.region : null,
      date: date,
      returnTicket: returnTicket,
      returnOrigin: returnTicket && returnOrigin ? returnOrigin.value : null,
      returnDestination:
        returnTicket && returnDestination ? returnDestination.value : null,
      returnDate: returnDate,
      adults: adults,
      children: children,
    };
    for (const key in formData) {
      console.log(`${key}:`, formData[key]);
    }

    try {
      let flightResults, hotelResults, carRentalResults;
      setLoading(true); // Start loading
      try {
        const recentSearch = await saveRecentSearch(formData, token, userId);
      } catch (error) {
        console.error("Error occurred while saving recent search: ", error);
      }

      try {
        flightResults = await getFlightResults(formData, token);
      } catch (error) {
        console.error("Error occurred while getting flight results: ", error);
      }

      try {
        hotelResults = await getHotelResults(formData, token);
      } catch (error) {
        console.error("Error occurred while getting hotel results: ", error);
      }

      try {
        carRentalResults = await getCarRentalResults(formData, token);
      } catch (error) {
        console.error(
          "Error occurred while getting car rental results: ",
          error
        );
      }

      setLoading(false);
      navigate("/table", {
        state: { flightResults, hotelResults, carRentalResults },
      });
    } catch (error) {
      console.error("Error occurred while getting results: ", error);
    }
  };

  const findMyLocation = () => {
    const success = (position) => {
      const latitude = position.coords.latitude;
      const longitude = position.coords.longitude;

      fetch(
        "https://aviation-reference-data.p.rapidapi.com/airports/search" +
          "?lat=" +
          latitude +
          "&lon=" +
          longitude +
          "&radius=200",
        {
          headers: {
            "X-RapidAPI-Key":
              "08d94f2f42mshecc916a55f33eacp1e93bbjsn71558a283d3d",
            "X-RapidAPI-Host": "aviation-reference-data.p.rapidapi.com",
          },
        }
      )
        .then((response) => {
          if (!response.ok) {
            throw new Error("Network response was not ok");
          }
          return response.json();
        })
        .then((data) => {
          console.log(data);
          const nearestAirport = findNearestAirport(latitude, longitude, data);
          const iataCode = nearestAirport.iataCode;
          const nearestOption = cityOptions.find(
            (option) => option.value === iataCode
          );
          setOrigin(nearestOption);
        })
        .catch((error) => {
          console.error("Error:", error);
          setStatus("Unable to retrieve your location");
        });
    };

    const error = (err) => {
      setStatus("Unable to retrieve your location");
    };

    if (!navigator.geolocation) {
      setStatus("Geolocation is not supported by your browser");
    } else {
      navigator.geolocation.getCurrentPosition(success, error);
    }
  };

  const calculateDistance = (lat1, lon1, lat2, lon2) => {
    const R = 6371;
    const dLat = ((lat2 - lat1) * Math.PI) / 180;
    const dLon = ((lon2 - lon1) * Math.PI) / 180;
    const a =
      Math.sin(dLat / 2) * Math.sin(dLat / 2) +
      Math.cos((lat1 * Math.PI) / 180) *
        Math.cos((lat2 * Math.PI) / 180) *
        Math.sin(dLon / 2) *
        Math.sin(dLon / 2);
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    const distance = R * c;
    return distance;
  };

  const findNearestAirport = (latitude, longitude, airports) => {
    let minDistance = Infinity;
    let nearestAirport = null;

    airports.forEach((airport) => {
      const distance = calculateDistance(
        latitude,
        longitude,
        airport.latitude,
        airport.longitude
      );
      if (distance < minDistance) {
        minDistance = distance;
        nearestAirport = airport;
      }
    });

    return nearestAirport;
  };

  return (
    <>
      <Form
        id="travelForm"
        style={{
          padding: "2rem",
          backgroundColor: "#f8f9fa",
          borderRadius: "15px",
          maxWidth: "90%",
        }}
        onSubmit={handleSubmit}
      >
        <h1 style={{ fontSize: "2rem" }}>Search</h1>
        <Form.Group controlId="origin">
          <Form.Label>Origin:</Form.Label>
          <InputGroup>
            <MySelect
              options={cityOptions}
              value={origin}
              onChange={(selectedOption) => {
                setOrigin(selectedOption);
                console.log(
                  "Selected origin:",
                  selectedOption ? selectedOption.label : null
                );
              }}
            />
            {origin && (
              <Button variant="outline-danger" onClick={() => setOrigin(null)}>
                <MdClear size={24} color="red" style={{ marginLeft: "10px" }} />
              </Button>
            )}
          </InputGroup>
          <Button
            variant="primary"
            onClick={findMyLocation}
            id="fetchData"
            type="button"
            style={{ marginTop: "-15px" }}
          >
            <MdGpsFixed size={18} color="blue" /> Use my location to find
            airport
          </Button>
          {status && <div id="status">{status}</div>}
        </Form.Group>

        <Form.Group controlId="destination">
          <Form.Label>Destination:</Form.Label>
          <InputGroup>
            <MySelect
              options={cityOptions}
              value={destination}
              onChange={(selectedOption) => {
                setDestination(selectedOption);
              }}
            />
            {destination && (
              <Button
                variant="outline-danger"
                onClick={() => setDestination(null)}
              >
                <MdClear size={24} color="red" style={{ marginLeft: "10px" }} />
              </Button>
            )}
          </InputGroup>
        </Form.Group>
        <Form.Group controlId="date">
          <Form.Label>Date:</Form.Label>
          <Form.Control
            type="date"
            required
            value={date}
            onChange={(e) => setDate(e.target.value)}
          />
        </Form.Group>
        <Form.Group controlId="returnTicket" style={{ flexDirection: "row" }}>
          <Form.Check
            type="checkbox"
            checked={returnTicket}
            onChange={(e) => setReturnTicket(e.target.checked)}
            style={{ display: "inline-block" }}
          />
          <Form.Label style={{ display: "inline-block", margin: "3px" }}>
            Return Ticket
          </Form.Label>
        </Form.Group>
        {returnTicket && (
          <>
            <Form.Group controlId="returnOrigin">
              <Form.Label>Return Origin:</Form.Label>
              <InputGroup>
                <MySelect
                  options={cityOptions}
                  value={returnOrigin}
                  onChange={(selectedOption) => {
                    setReturnOrigin(selectedOption);
                  }}
                />
                {returnOrigin && (
                  <Button
                    variant="outline-danger"
                    onClick={() => setReturnOrigin(null)}
                  >
                    <MdClear
                      size={24}
                      color="red"
                      style={{ marginLeft: "10px" }}
                    />
                  </Button>
                )}
              </InputGroup>
            </Form.Group>
            <Form.Group controlId="returnDestination">
              <Form.Label>Return Destination:</Form.Label>
              <InputGroup>
                <MySelect
                  options={cityOptions}
                  value={returnDestination}
                  onChange={(selectedOption) => {
                    setReturnDestination(selectedOption);
                  }}
                />
                {returnDestination && (
                  <Button
                    variant="outline-danger"
                    onClick={() => setReturnDestination(null)}
                  >
                    <MdClear
                      size={24}
                      color="red"
                      style={{ marginLeft: "10px" }}
                    />
                  </Button>
                )}
              </InputGroup>
            </Form.Group>
            <Form.Group controlId="returnDate">
              <Form.Label>Return Date:</Form.Label>
              <Form.Control
                type="date"
                value={returnDate}
                onChange={(e) => setReturnDate(e.target.value)}
              />
            </Form.Group>
          </>
        )}
        <Form.Group controlId="adults">
          <Form.Label>Number of Adults:</Form.Label>
          <Form.Control
            type="number"
            min="1"
            required
            value={adults}
            onChange={(e) => setAdults(e.target.value)}
          />
        </Form.Group>
        <Form.Group controlId="children">
          <Form.Label>Number of Children:</Form.Label>
          <Form.Control
            type="number"
            min="0"
            value={children}
            onChange={(e) => setChildren(e.target.value)}
          />
        </Form.Group>
        <Button
          variant="primary"
          style={{ backgroundColor: "#0000A0" }}
          type="submit"
          id="submitForm"
        >
          Search
        </Button>
      </Form>
      {loading && (
        <div className="overlay">
          <ClipLoader color={"#0000A0"} size={150} />
        </div>
      )}
    </>
  );
};

export default SearchFlights;
