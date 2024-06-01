import React from "react";
import ReactDOM from "react-dom";
import TableOfHotels  from "./Components/TableOfHotels";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import HotelDetails from './Components/ExtraInfo';


import "./index.css";

const App = () => (
  <Router>
  {/* Other routes... */}
  <Routes>
  <Route path="/hotel-details" element={<HotelDetails />} />
  </Routes>
</Router>

);
ReactDOM.render(<App />, document.getElementById("app"));
