import React, { useState, useEffect } from 'react';
import {apis} from "../../utils/apis.js";
const UserProfile = () => {
    const [username, setUsername] = useState();
    const [email, setEmail] = useState();
    const [firstName, setFirstName] = useState();
    const [lastName, setLastName] = useState();
    const [role, setRole] = useState();

    useEffect(()=> {

        apis.getUserById(1).then(
          res => {
            const data = res.data;
            setUsername(data.username);
            setEmail(data.email);
            setFirstName(data.firstName);
            setLastName(data.lastName);
            setRole(data.role);
          }
        )
      }, [])

    return(
        <div>
            <p>Username: {username}</p>
            <p>First name: {firstName}</p>
            <p>Last name: {lastName}</p>
            <p>Email: {email}</p>
            <p>Role: {role}</p>
        </div>
    )
}
export default UserProfile