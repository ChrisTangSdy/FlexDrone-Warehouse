import React, { useState } from "react";
import { apis } from "../../utils/apis.js";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  // const [showError, setShowError] = useState(false);

  const onLoginSubmit = (e) => {
    let loginInfo = { username, password };
    apis
      .logIn(loginInfo)
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
                    <form novalidate="">
                      <div className="d-flex align-items-center mb-4 pb-1">
                        <span className="h1 fw-bold mb-0">Sign In</span>
                      </div>

                      <div className="form-floating mb-4">
                        <input
                          type="text"
                          className="form-control"
                          id="floatingInput"
                          placeholder="username123"
                          value={username}
                          onChange={(e) => setUsername(e.target.value)}
                          required
                        />
                        <label htmlFor="floatingInput">Username</label>
                        <div class="invalid-feedback">
                          Please choose a username.
                        </div>
                      </div>
                      <div className="form-floating mb-4">
                        <input
                          type="password"
                          className="form-control"
                          id="floatingPassword"
                          placeholder="Password123"
                          value={password}
                          onChange={(e) => setPassword(e.target.value)}
                        />
                        <label htmlFor="floatingPassword">Password</label>
                      </div>
                      <div className="pt-1 mb-4">
                        <button
                          className="btn btn-dark btn-lg btn-block"
                          type="button"
                          onClick={onLoginSubmit}
                        >
                          Login
                        </button>
                      </div>

                      <a className="small text-muted" href="#!">
                        Forgot password?
                      </a>
                    </form>
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
