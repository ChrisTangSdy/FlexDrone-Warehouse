import React, { useState } from "react";
import { apis } from "../../utils/apis.js";
import { FloatingLabel, Form, Button } from "react-bootstrap";

const Login = () => {
  const [form, setForm] = useState({});
  const [errors, setErrors] = useState({});

  const setField = (field, value) => {
    // add or update value for the field to the form
    setForm({ ...form, [field]: value });

    // remove the existing error for the field
    if (!!errors[field]) {
      setErrors({
        ...errors,
        [field]: null,
      });
    }
  };

  // validate form and customize error messages
  const validateForm = () => {
    const { username, password } = form;
    const newErrors = {};

    if (!username || username === "")
      newErrors.username = "Please enter your username";
    if (!password || password === "")
      newErrors.password = "Please enter your password";

    return newErrors;
  };

  // handle login form submit
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("login form submitted");

    // validate form
    const formErrors = validateForm();

    if (Object.keys(formErrors).length > 0) {
      setErrors(formErrors);
    } else {
      // if no error, make API request
      apis
        .logIn(form)
        .then((res) => {
          // save JWT into sessionStorage
          sessionStorage.setItem("token", res.data);
          // redirect the page
          document.location.href = "/ViewUser";
        })
        .catch((err) => {
          // if status code is 400/401/404
          if (err.response.status.toString().startsWith("4"))
            return alert("Incorrect username or password");

          // if other status code
          alert(err.response.data.message);
        });
    }
  };

  return (
    <section className="vh-100" style={{ backgroundColor: "#eee" }}>
      <div className="container py-5 h-100">
        <div className="row d-flex justify-content-center align-items-center h-100">
          <div className="col col-xl-10">
            <div className="card" style={{ borderRadius: "1rem" }}>
              <div className="row g-0">
                <div className="col-md-6 col-lg-5 d-none d-md-block">
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
                    alt="login form"
                    className="img-fluid"
                    style={{ borderRadius: "1rem 0 0 1rem" }}
                  />
                </div>
                <div className="col-md-6 col-lg-7 d-flex align-items-center">
                  <div className="card-body p-4 p-lg-5 text-black">
                    <Form onSubmit={handleSubmit}>
                      <h1 className="fw-bold mb-4">Sign In</h1>
                      <Form.Group controlId="username">
                        <FloatingLabel label="Username" className="mb-4">
                          <Form.Control
                            type="text"
                            value={form.username}
                            onChange={(e) =>
                              setField("username", e.target.value)
                            }
                            isInvalid={!!errors.username}
                          />
                          <Form.Control.Feedback type="invalid">
                            {errors.username}
                          </Form.Control.Feedback>
                        </FloatingLabel>
                      </Form.Group>

                      <Form.Group controlId="password">
                        <FloatingLabel label="Password" className="mb-4">
                          <Form.Control
                            type="password"
                            value={form.password}
                            onChange={(e) =>
                              setField("password", e.target.value)
                            }
                            isInvalid={!!errors.password}
                          />
                          <Form.Control.Feedback type="invalid">
                            {errors.password}
                          </Form.Control.Feedback>
                        </FloatingLabel>
                      </Form.Group>
                      <Form.Group>
                        <div className="d-grid pt-1 mb-4">
                          <Button variant="primary" size="lg" type="submit">
                            Login
                          </Button>
                        </div>
                      </Form.Group>
                      <a className="small text-muted" href="#!">
                        Forgot password?
                      </a>
                    </Form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Login;
