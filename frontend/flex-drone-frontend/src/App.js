import "./assets/styles.css";
import {BrowserRouter, Routes, Route, redirect, Navigate} from "react-router-dom";
import UserProfile from "./pages/User/index.jsx";
import React from "react";

function App() {
  return (
    <div className="app">
      <p>Hello!</p>
      <UserProfile />
    </div>
  );
}

export default App;
