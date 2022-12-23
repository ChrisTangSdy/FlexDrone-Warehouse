import React, { useState, useEffect } from "react";
import { apis } from "../../utils/apis.js";
import Button from "react-bootstrap/Button";
import Alert from "react-bootstrap/Alert";

import {
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
} from "mdb-react-ui-kit";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [showError, setShowError] = useState(false);

  const handleSubmit = (event) => {
    console.log("submit clicked");
    let loginInfo = { username, password };
    apis
      .logIn(loginInfo)
      .then((res) => {
        sessionStorage.setItem("token", res.data);
        document.location.href = "/";
      })
      .catch((e) => {
        setShowError(true);
      });
  };

  return (
    <MDBContainer fluid>
      <MDBRow className="d-flex justify-content-center align-items-center h-100">
        <MDBCol col="12">
          <MDBCard
            className="bg-dark text-white my-5 mx-auto"
            style={{ borderRadius: "1rem", maxWidth: "400px" }}
          >
            <MDBCardBody className="p-5 d-flex flex-column align-items-center mx-auto w-100">
              <h2 className="fw-bold mb-2 text-uppercase">Login</h2>
              <p className="text-white-50 mb-5">
                Please enter your login and password!
              </p>

              <MDBInput
                wrapperClass="mb-4 mx-5 w-100"
                labelClass="text-white"
                label="Username"
                id="formControlLg"
                type="text"
                value={username}
                size="lg"
                onChange={(e) => setUsername(e.target.value)}
              />
              <MDBInput
                wrapperClass="mb-4 mx-5 w-100"
                labelClass="text-white"
                label="Password"
                id="formControlLg"
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                size="lg"
              />
              <Alert key="danger" variant="danger" hidden={!showError}>
                Your login details are incorrect!
              </Alert>
              <Button size="lg" variant="secondary" onClick={handleSubmit}>
                Submit
              </Button>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
  );
};

export default Login;
