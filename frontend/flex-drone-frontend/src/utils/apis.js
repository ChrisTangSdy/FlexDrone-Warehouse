import axios from 'axios';
// import { getCookie, getUserRole} from './cookies';

export const apis = {
    getUserById,
    changePassword

}

// const config = {
//     headers: { Authorization: `Bearer ${getCookie('token')}` }
// }

const config = {
    headers: {'Content-type': 'application/json'}
}

const instance = axios.create({
    baseURL: 'http://localhost:8088/flex-drone-warehouse'
})


function getUserById(id){
    return instance.get("/warehouse-users/" + id);
}

function changePassword(id, newPass){
    return instance.put("/warehouse-users/" + id +"/password", newPass,config);
}

