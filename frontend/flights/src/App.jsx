import React from "react";
import ReactDOM from "react-dom";

import "./index.scss";

const rows = [
  {
    price: {
      amount: 100,
      unit: "USD"
    },
    originPlace: 'New York',
    destinationPlace: 'London',
    departureDateTime: '2022-12-01T10:00:00',
    arrivalDateTime: '2022-12-01T20:00:00',
    bookingLink: 'https://example.com/booking1',
    carriers: [
      {
        name: 'Carrier 1',
        imageUrl: 'https://static.tacdn.com/img2/flights/airlines/logos/100x100/AustrianAirlines.png',
      },
      {
        name: 'Carrier 2',
        imageUrl: 'https://static.tacdn.com/img2/flights/airlines/logos/100x100/AustrianAirlines.png',
      },
    ],
    agents: [
      {
        name: 'Agent 1',
        imageUrl: 'https://static.tacdn.com/img2/flights/airlines/logos/100x100/AustrianAirlines.png',
      },
      {
        name: 'Agent 2',
        imageUrl: 'https://static.tacdn.com/img2/flights/airlines/logos/100x100/AustrianAirlines.png',
      },
    ],
    legs: [
      {
        originPlace: 'New York',
        destinationPlace: 'London',
        departureDateTime: '2022-12-01T10:00:00',
        arrivalDateTime: '2022-12-01T20:00:00',
      },
      // More legs...
    ],
  },
  {
    price: {
      amount: 100,
      unit: "USD"
    },
    originPlace: 'Paris',
    destinationPlace: 'Tokyo',
    departureDateTime: '2022-12-02T10:00:00',
    arrivalDateTime: '2022-12-03T10:00:00',
    bookingLink: 'https://example.com/booking2',
    carriers: [
      {
        name: 'Carrier 3',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Carrier 4',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    agents: [
      {
        name: 'Agent 3',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Agent 4',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    legs: [
      {
        originPlace: 'Paris',
        destinationPlace: 'Tokyo',
        departureDateTime: '2022-12-02T10:00:00',
        arrivalDateTime: '2022-12-03T10:00:00',
      },
      // More legs...
    ],
  },
  {
    price: {
      amount: 100,
      unit: "USD"
    },
    originPlace: 'New York',
    destinationPlace: 'London',
    departureDateTime: '2022-12-01T10:00:00',
    arrivalDateTime: '2022-12-01T20:00:00',
    bookingLink: 'https://example.com/booking1',
    carriers: [
      {
        name: 'Carrier 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Carrier 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    agents: [
      {
        name: 'Agent 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Agent 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    legs: [
      {
        originPlace: 'New York',
        destinationPlace: 'London',
        departureDateTime: '2022-12-01T10:00:00',
        arrivalDateTime: '2022-12-01T20:00:00',
      },
      // More legs...
    ],
  },
  {
    price: {
      amount: 100,
      unit: "USD"
    },
    originPlace: 'New York',
    destinationPlace: 'London',
    departureDateTime: '2022-12-01T10:00:00',
    arrivalDateTime: '2022-12-01T20:00:00',
    bookingLink: 'https://example.com/booking1',
    carriers: [
      {
        name: 'Carrier 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Carrier 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    agents: [
      {
        name: 'Agent 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Agent 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    legs: [
      {
        originPlace: 'New York',
        destinationPlace: 'London',
        departureDateTime: '2022-12-01T10:00:00',
        arrivalDateTime: '2022-12-01T20:00:00',
      },
      // More legs...
    ],
  },
  {
    price: {
      amount: 100,
      unit: "USD"
    },
    originPlace: 'New York',
    destinationPlace: 'London',
    departureDateTime: '2022-12-01T10:00:00',
    arrivalDateTime: '2022-12-01T20:00:00',
    bookingLink: 'https://example.com/booking1',
    carriers: [
      {
        name: 'Carrier 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Carrier 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    agents: [
      {
        name: 'Agent 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Agent 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    legs: [
      {
        originPlace: 'New York',
        destinationPlace: 'London',
        departureDateTime: '2022-12-01T10:00:00',
        arrivalDateTime: '2022-12-01T20:00:00',
      },
      // More legs...
    ],
  },
  {
    price: {
      amount: 100,
      unit: "USD"
    },
    originPlace: 'New York',
    destinationPlace: 'London',
    departureDateTime: '2022-12-01T10:00:00',
    arrivalDateTime: '2022-12-01T20:00:00',
    bookingLink: 'https://example.com/booking1',
    carriers: [
      {
        name: 'Carrier 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Carrier 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    agents: [
      {
        name: 'Agent 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Agent 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    legs: [
      {
        originPlace: 'New York',
        destinationPlace: 'London',
        departureDateTime: '2022-12-01T10:00:00',
        arrivalDateTime: '2022-12-01T20:00:00',
      },
      // More legs...
    ],
  },
  {
    price: {
      amount: 100,
      unit: "USD"
    },
    originPlace: 'New York',
    destinationPlace: 'London',
    departureDateTime: '2022-12-01T10:00:00',
    arrivalDateTime: '2022-12-01T20:00:00',
    bookingLink: 'https://example.com/booking1',
    carriers: [
      {
        name: 'Carrier 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Carrier 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    agents: [
      {
        name: 'Agent 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Agent 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    legs: [
      {
        originPlace: 'New York',
        destinationPlace: 'London',
        departureDateTime: '2022-12-01T10:00:00',
        arrivalDateTime: '2022-12-01T20:00:00',
      },
      // More legs...
    ],
  },
  {
    price: {
      amount: 100,
      unit: "USD"
    },
    originPlace: 'New York',
    destinationPlace: 'London',
    departureDateTime: '2022-12-01T10:00:00',
    arrivalDateTime: '2022-12-01T20:00:00',
    bookingLink: 'https://example.com/booking1',
    carriers: [
      {
        name: 'Carrier 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Carrier 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    agents: [
      {
        name: 'Agent 1',
        imageUrl: 'https://via.placeholder.com/150',
      },
      {
        name: 'Agent 2',
        imageUrl: 'https://via.placeholder.com/150',
      },
    ],
    legs: [
      {
        originPlace: 'New York',
        destinationPlace: 'London',
        departureDateTime: '2022-12-01T10:00:00',
        arrivalDateTime: '2022-12-01T20:00:00',
      },
      // More legs...
    ],
  },
  {
    price: {
      amount: 100,
      unit: "USD"
    },
    originPlace: 'New York',
    destinationPlace: 'London',
    departureDateTime: '2022-12-01T10:00:00',
    arrivalDateTime: '2022-12-01T20:00:00',
    bookingLink: 'https://example.com/booking1',
    carriers: [
      {
        name: 'Carrier 1',
        imageUrl: 'https://static.tacdn.com/img2/flights/airlines/logos/100x100/AustrianAirlines.png',
      },
      {
        name: 'Carrier 2',
        imageUrl: 'https://static.tacdn.com/img2/flights/airlines/logos/100x100/AustrianAirlines.png',
      },
    ],
    agents: [
      {
        name: 'Agent 1',
        imageUrl: 'https://static.tacdn.com/img2/flights/airlines/logos/100x100/AustrianAirlines.png',
      },
      {
        name: 'Agent 2',
        imageUrl: 'https://static.tacdn.com/img2/flights/airlines/logos/100x100/AustrianAirlines.png',
      },
    ],
    legs: [
      {
        originPlace: 'New York',
        destinationPlace: 'London',
        departureDateTime: '2022-12-01T10:00:00',
        arrivalDateTime: '2022-12-01T20:00:00',
      },
      // More legs...
    ],
  },
  // More itineraries...
];
const user = {
  username: 'johndoe123',
  name: 'John',
  surname: 'Doe',
  phoneNumber: '123-456-7890',
  email: 'johndoe@example.com',
  savedFlights: [
    {
      price: 100,
      originPlace: 'New York',
      destinationPlace: 'London',
      departureDateTime: '2022-12-01T10:00:00',
      arrivalDateTime: '2022-12-01T20:00:00',
      bookingLink: 'https://example.com/booking1',
    },
    {
      price: 100,
      originPlace: 'New York',
      destinationPlace: 'London',
      departureDateTime: '2022-12-01T10:00:00',
      arrivalDateTime: '2022-12-01T20:00:00',
      bookingLink: 'https://example.com/booking1',
    },
    // Add more flights here
  ],savedHotels: [
  {
    id: '1',
    name: 'Hotel 1',
    city: 'City 1',
    country: 'Country 1',
    address: 'Address 1',
    starRating: '5',
    minPrice: '100',
    hotelRank: '1',
    imageUrl: 'url_to_image_1',
  },
  {
    id: '2',
    name: 'Hotel 2',
    city: 'City 2',
    country: 'Country 2',
    address: 'Address 2',
    starRating: '4',
    minPrice: '80',
    hotelRank: '2',
    imageUrl: 'url_to_image_2',
  },
  {
    id: '3',
    name: 'Hotel 3',
    city: 'City 3',
    country: 'Country 3',
    address: 'Address 3',
    starRating: '3',
    minPrice: '60',
    hotelRank: '3',
    imageUrl: 'url_to_image_3',
  },
  // ... add more hotels as needed
],
  
  savedCarRentals: ['Car Rental 1', 'Car Rental 2', 'Car Rental 3'],
  recentSearches: ['Search 1', 'Search 2', 'Search 3'],
};




export const App = () => (
  <></>
);

ReactDOM.render(<App />, document.getElementById("app"));