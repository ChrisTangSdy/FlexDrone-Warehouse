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
                      <div class="d-flex align-items-center mb-3 pb-1">
                        <i
                          class="bi bi-boxes me-3"
                          style={{ color: "#ff6219", fontSize: "2.5em" }}
                        ></i>
                        <span class="h1 fw-bold mb-0">FlexDrone Warehouse</span>
                      </div>

                      <h5
                        class="fw-normal mb-3 pb-3"
                        style={{ letterSpacing: "1px" }}
                      >
                        Sign into your account
                      </h5>

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

// // THE FOLLOWING CODE IS FROM VIVIAN
// import React, { useState, useEffect } from "react";
// import { apis } from "../../utils/apis.js";
// import Button from "react-bootstrap/Button";
// import Alert from "react-bootstrap/Alert";

// import {
//   MDBContainer,
//   MDBRow,
//   MDBCol,
//   MDBCard,
//   MDBCardBody,
//   MDBInput,
// } from "mdb-react-ui-kit";

// const Login = () => {
//   const [username, setUsername] = useState("");
//   const [password, setPassword] = useState("");
//   const [showError, setShowError] = useState(false);

//   const handleSubmit = (event) => {
//     console.log("submit clicked");
//     let loginInfo = { username, password };
//     apis
//       .logIn(loginInfo)
//       .then((res) => {
//         sessionStorage.setItem("token", res.data);
//         document.location.href = "/";
//       })
//       .catch((e) => {
//         setShowError(true);
//       });
//   };

//   return (
//     <MDBContainer fluid>
//       <MDBRow className="d-flex justify-content-center align-items-center h-100">
//         <MDBCol col="12">
//           <MDBCard
//             className="bg-dark text-white my-5 mx-auto"
//             style={{ borderRadius: "1rem", maxWidth: "400px" }}
//           >
//             <MDBCardBody className="p-5 d-flex flex-column align-items-center mx-auto w-100">
//               <h2 className="fw-bold mb-2 text-uppercase">Login</h2>
//               <p className="text-white-50 mb-5">
//                 Please enter your login and password!
//               </p>

//               <MDBInput
//                 wrapperClass="mb-4 mx-5 w-100"
//                 labelClass="text-white"
//                 label="Username"
//                 id="formControlLg"
//                 type="text"
//                 value={username}
//                 size="lg"
//                 onChange={(e) => setUsername(e.target.value)}
//               />
//               <MDBInput
//                 wrapperClass="mb-4 mx-5 w-100"
//                 labelClass="text-white"
//                 label="Password"
//                 id="formControlLg"
//                 type="password"
//                 value={password}
//                 onChange={(e) => setPassword(e.target.value)}
//                 size="lg"
//               />
//               <Alert key="danger" variant="danger" hidden={!showError}>
//                 Your login details are incorrect!
//               </Alert>
//               <Button size="lg" variant="secondary" onClick={handleSubmit}>
//                 Submit
//               </Button>
//             </MDBCardBody>
//           </MDBCard>
//         </MDBCol>
//       </MDBRow>
//     </MDBContainer>
//   );
// };

// export default Login;
