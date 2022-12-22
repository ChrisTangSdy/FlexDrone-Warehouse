import React, { useState, useEffect } from "react";
import { apis } from "../../utils/apis.js";
import { getUserId } from "../../utils/processJwt.js";

const UserProfile = () => {
  const [username, setUsername] = useState();
  const [email, setEmail] = useState();
  const [firstName, setFirstName] = useState();
  const [lastName, setLastName] = useState();
  const [role, setRole] = useState();

  useEffect(() => {
    apis.getUserById(getUserId()).then((res) => {
      const data = res.data;
      setUsername(data.username);
      setEmail(data.email);
      setFirstName(data.firstName);
      setLastName(data.lastName);
      setRole(data.role);
    });
  }, []);

  return (
    <section className="vh-100" style={{ backgroundColor: "#eee" }}>
      <div className="container py-5 h-100">
        <div className="row justify-content-center align-items-center h-100">
          <div className="col col-md-10 col-xl-8">
            <div className="card" style={{ borderRadius: "15px" }}>
              <div className="card-body p-4 text-center">
                <div className="mt-3 mb-4">
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                    className="rounded-circle img-fluid"
                    style={{ width: "100px" }}
                    alt="profile"
                  />
                </div>
                <h4 className="card-title mb-4">{`${firstName} ${lastName}`}</h4>
                <h6 className="card-subtitle mb-2">{role}</h6>
                <h6 className="card-subtitle text-muted mb-4">{`@${username}`}</h6>
                <p className="card-text text-muted mb-4">
                  Email<span className="mx-2">|</span> {email}
                </p>

                <div className="mb-4 pb-2">
                  <btn
                    className="btn btn-outline-primary btn-floating mx-1"
                    type="button"
                  >
                    <i
                      className="bi bi-microsoft-teams"
                      style={{ color: "cornflowerblue" }}
                    ></i>
                  </btn>
                  <btn
                    className="btn btn-outline-primary btn-floating mx-1"
                    type="button"
                  >
                    <i
                      className="bi bi-twitter"
                      style={{ color: "cornflowerblue" }}
                    ></i>
                  </btn>
                  <btn
                    className="btn btn-outline-primary btn-floating mx-1"
                    type="button"
                  >
                    <i
                      className="bi bi-linkedin"
                      style={{ color: "cornflowerblue" }}
                    ></i>
                  </btn>
                </div>
                <btn
                  className="btn btn-primary btn-rounded btn-lg mx-1"
                  type="button"
                >
                  Message now
                </btn>
                <div className="d-flex justify-content-between text-center mt-5 mb-2"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default UserProfile;
