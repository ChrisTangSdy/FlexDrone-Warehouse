import jwt_decode from 'jwt-decode';

export function getUserId() {
  if (isLoggedIn()) {
    const payload = jwt_decode(sessionStorage.getItem('token'));
    return payload.userId;
  }
  return null;
}

export function getUserRole() {
  if (isLoggedIn()) {
    const payload = jwt_decode(sessionStorage.getItem('token'));
    return payload.role[0]['authority'];
  }
  return null;
}

export function isLoggedIn() {
  return sessionStorage.getItem('token') !== '';
}
