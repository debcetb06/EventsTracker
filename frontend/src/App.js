import React from "react";
import "./App.css";
import EventDetails from "./components/eventDetails";
import NavBar from "./components/navBar";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function App() {
  return (
    <React.Fragment>
      <ToastContainer />
      <NavBar />
      <main className="container">
        <EventDetails />
      </main>
    </React.Fragment>
  );
}

export default App;
