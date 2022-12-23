import "./assets/styles.scss";
import React, { Fragment } from "react";
import Login from "./pages/Login";
import Main from "./components/Main";

function App() {
  let token = sessionStorage.getItem("token");
  return <Fragment>{token == null ? <Login /> : <Main />}</Fragment>;
}

export default App;
