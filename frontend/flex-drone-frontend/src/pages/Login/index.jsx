import React, { useState, useEffect } from "react";
import { apis } from "../../utils/apis.js";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Alert from "react-bootstrap/Alert";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [showError, setShowError] = useState(false);

  const handleSubmit = (event) => {
    console.log("submit clicked");
    setShowError(true);
  };

  return (
    <Container style={{ "padding-top": "30%" }}>
      <Row className="justify-content-md-center ">
        {/* <Col xs lg="2">
              1 of 3
            </Col> */}
        <Col lg={6}>
          <Form>
            <Form.Group className="mb-3" controlId="formBasicPassword">
              <Form.Label>Username</Form.Label>
              <Form.Control
                type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </Form.Group>
            <Alert key="danger" variant="danger" hidden={!showError}>
              Your login details are incorrect!
            </Alert>

            <Button variant="primary" onClick={handleSubmit}>
              Submit
            </Button>
          </Form>
        </Col>
        {/* <Col xs lg="2">
              3 of 3
            </Col> */}
      </Row>
    </Container>
  );
};

export default Login;
