import "./App.css";
import DropdownCountries from "./components/DropdownCountries";
import LineChart from "./components/LineChart";
import React, { useState } from "react";

function App() {
  const [country_id, setCountryId] = useState("");

  const eventhandler = (data) => {
    setCountryId(data);
    // console.log("app: state.selected_value -> " + country_id);
  };

  return (
    <div className="App">
      <h1>Covid 19 Stats App</h1>
      <DropdownCountries onChange={eventhandler} />
      <LineChart selected_value={country_id} />
    </div>
  );
}

export default App;
