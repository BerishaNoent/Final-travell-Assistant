import React, { useState } from "react";
import {
  TextField,
  Button,
  Select,
  MenuItem,
  InputLabel,
  FormControl,
  Box,
  Grid,
} from "@mui/material";
import { publishAirport, removeAirport } from "../Api";
import { toast } from "react-toastify";
import { Paper } from "@mui/material";
import ConfirmationDialog from "./ConfirmationDialog";

function AddForm({ countries, token }) {
  const [selectedCountry, setSelectedCountry] = useState("");
  const [selectedCity, setSelectedCity] = useState("");
  const [newCountry, setNewCountry] = useState("");
  const [newCity, setNewCity] = useState("");
  const [cityIataCode, setCityIataCode] = useState("");
  const [newAirport, setNewAirport] = useState("");
  const [airportIataCode, setAirportIataCode] = useState("");
  const [addNewCountry, setAddNewCountry] = useState(false);
  const [addNewCity, setAddNewCity] = useState(false);
  const [removeIataCode, setRemoveIataCode] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const selectedCountryObject = countries.find(
      (country) => country.name === selectedCountry
    );

    const formValues = {
      id: addNewCountry ? null : selectedCountryObject?.id,
      name: addNewCountry ? newCountry : selectedCountry,
      Cities: [
        {
          Location: addNewCity ? newCity : selectedCity,
          IATA_Code: cityIataCode,
          Airports: [
            {
              Name: newAirport,
              IATA_Code: airportIataCode,
            },
          ],
        },
      ],
    };

    if (
      !formValues.name ||
      !formValues.Cities[0].Location ||
      !formValues.Cities[0].Airports[0].Name ||
      !formValues.Cities[0].Airports[0].IATA_Code
    ) {
      toast.error("You must fill all required fields");
      return;
    }

    console.log(formValues);

    try {
      const response = await publishAirport(formValues, token);
      if (response.status === 200) {
        toast.success("Airport successfully added");
      } else {
        toast.error("Failed to save the Airport");
      }
    } catch (error) {
      toast.error("Failed to save the Airport");
    }
  };

  const handleRemove = async () => {
    try {
      const response = await removeAirport(removeIataCode, token);
      if (
        response.body === "No response received" ||
        response.body === "Failed to remove airport"
      ) {
        toast.error("Unsuccessful: No response received");
      } else {
        toast.success("Airport removed successfully");
      }
    } catch (error) {
      console.error("Failed to remove airport:", error);
      toast.error("Failed to remove airport");
    }
  };

  const handleCountryChange = (e) => {
    setSelectedCountry(e.target.value);
    setSelectedCity("");
  };

  return (
    <Paper sx={{ padding: "1rem", fontFamily: "Oswald, sans-serif" }}>
      <form onSubmit={handleSubmit}>
        {!addNewCountry ? (
          <FormControl fullWidth>
            <InputLabel
              id="country-select-label"
              sx={{ fontFamily: "Oswald, sans-serif" }}
            >
              Country
            </InputLabel>
            <Select
              labelId="country-select-label"
              value={selectedCountry}
              onChange={handleCountryChange}
              sx={{ fontFamily: "Oswald, sans-serif" }}
            >
              {countries.map((country) => (
                <MenuItem
                  sx={{ fontFamily: "Oswald, sans-serif" }}
                  key={country.name}
                  value={country.name}
                >
                  {country.name}
                </MenuItem>
              ))}
            </Select>

            <Button
              onClick={() => setAddNewCountry(true)}
              sx={{ fontFamily: "Oswald, sans-serif" }}
            >
              Add New Country
            </Button>
          </FormControl>
        ) : (
          <TextField
            label="New Country"
            value={newCountry}
            onChange={(e) => setNewCountry(e.target.value)}
            style={{ margin: 3 }}
          />
        )}
        {!addNewCity ? (
          <FormControl fullWidth>
            <InputLabel
              sx={{ fontFamily: "Oswald, sans-serif" }}
              id="city-select-label"
            >
              City
            </InputLabel>
            <Select
              labelId="city-select-label"
              value={selectedCity}
              onChange={(e) => setSelectedCity(e.target.value)}
              disabled={!selectedCountry}
              sx={{ fontFamily: "Oswald, sans-serif" }}
            >
              {selectedCountry &&
                countries
                  .find((country) => country.name === selectedCountry)
                  .Cities.map((city) => (
                    <MenuItem
                      sx={{ fontFamily: "Oswald, sans-serif" }}
                      key={city.IATA_Code}
                      value={city.Location}
                    >
                      {city.Location} ({city.IATA_Code})
                    </MenuItem>
                  ))}
            </Select>

            <Button
              onClick={() => setAddNewCity(true)}
              sx={{ fontFamily: "Oswald, sans-serif" }}
            >
              Add New City
            </Button>
          </FormControl>
        ) : (
          <>
            <TextField
              label="New City"
              value={newCity}
              onChange={(e) => setNewCity(e.target.value)}
              style={{ margin: 3, fontFamily: "Oswald, sans-serif" }}
            />
            <TextField
              label="City IATA Code"
              value={cityIataCode}
              onChange={(e) => setCityIataCode(e.target.value)}
              style={{ margin: 3, fontFamily: "Oswald, sans-serif" }}
            />
          </>
        )}
        <TextField
          label="New Airport"
          value={newAirport}
          onChange={(e) => setNewAirport(e.target.value)}
          style={{ margin: 2 }}
        />
        <TextField
          label="Airport IATA Code"
          value={airportIataCode}
          onChange={(e) => setAirportIataCode(e.target.value)}
          style={{ margin: 2, fontFamily: "Oswald, sans-serif" }}
        />
        <Grid container justify="center" style={{ margin: 2 }}>
          <Button type="submit" sx={{ fontFamily: "Oswald, sans-serif" }}>
            Add
          </Button>
        </Grid>

        <TextField
          label="IATA Code to Remove"
          value={removeIataCode}
          onChange={(e) => setRemoveIataCode(e.target.value)}
          style={{ fontFamily: "Oswald, sans-serif" }}
        />
        <Grid
          container
          justify="center"
          style={{ margin: 2, fontFamily: "Oswald, sans-serif" }}
        >
          <ConfirmationDialog onConfirm={handleRemove}>
            Remove
          </ConfirmationDialog>
        </Grid>
      </form>
    </Paper>
  );
}

export default AddForm;
