import React from "react";
import "./App.css";
import EventDetails from "./components/eventDetails";
import NavBar from "./components/navBar";

function App() {
  return (
    <React.Fragment>
      <NavBar />
      <main className="container">
        <EventDetails />
      </main>
    </React.Fragment>
  );
}

export default App;
