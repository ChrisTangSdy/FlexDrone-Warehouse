import axios from "axios";
// import { getCookie, getUserRole} from './cookies';

export const apis = {
  getUserById,
  changePassword,
  logIn,
  checkPassword,
};

const config = {
  headers: {
    // "Content-type": "application/json",
    authorization: `Bearer ${sessionStorage.getItem("token")}`,
  },
};

const instance = axios.create({
  baseURL: "http://localhost:8088/flex-drone-warehouse",
});

function getUserById(id) {
  return instance.get("/warehouse-users/" + id, config);
}

function changePassword(id, newPass) {
  const data = { text: newPass };
  return instance.put("/warehouse-users/" + id + "/password", data, config);
}

function logIn(loginInfo) {
  return instance.post("/authenticate/login", loginInfo);
}

function checkPassword(id, curPass) {
  const data = { text: curPass };

  return instance.post(
    "/warehouse-users/" + id + "/checkPassword",
    data,
    config
  );
}
