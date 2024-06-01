import React from "react";
import ReactDOM from "react-dom";

import "./index.scss";
const backendUrl = process.env.REACT_APP_BACKEND_URL;
const App = () => (
  <div className="container">
    <div>Name: flights2</div>
    <div>Framework: react</div>
    <div>Language: JavaScript</div>
    <div>CSS: Empty CSS</div>
    <div> njadkaw{backendUrl}</div>
  </div>
);
ReactDOM.render(<App />, document.getElementById("app"));
