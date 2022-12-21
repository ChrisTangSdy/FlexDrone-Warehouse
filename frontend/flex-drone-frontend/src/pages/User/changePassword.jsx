import React, { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Alert from 'react-bootstrap/Alert';
import {apis} from "../../utils/apis.js";
import {useNavigate} from "react-router-dom";


const ChangePassword = () => {

    const navigate = useNavigate();

    const [curPassword, setCurPassword] = useState('');
    const [newPassword, setNewPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');

    const [passwordMatch, setPasswordMatch] = useState(true);

    useEffect(() => {
        setPasswordMatch(newPassword === confirmPassword);
    }, [newPassword,confirmPassword])

    const handleSubmit = (event) => {
        console.log("submit clicked");
        // check if current password match in database

        // update password with changePassword api
        if(passwordMatch && newPassword.length > 0) {
            console.log(newPassword)
            const data = {
                'text':newPassword
            }
            apis.changePassword(1,data) //using user id of 1 for now
            .then(res => {
                navigate('/ViewUser')
                console.log("api succeeded")
            })
            .catch((err) => {
                console.log(err)
            })
        }

        // log out
    }

    return (
    <Container>
      <Row className="justify-content-md-center">
        {/* <Col xs lg="2">
          1 of 3
        </Col> */}
        <Col lg={6}>
            <Form>
            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Current Password</Form.Label>
                <Form.Control 
                type="password" 
                value={curPassword}
                onChange={e => setCurPassword(e.target.value)}
                />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>New Password</Form.Label>
                <Form.Control 
                type="password" 
                value={newPassword}
                onChange={e => setNewPassword(e.target.value)}
                />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Confirm New Password</Form.Label>
                <Form.Control 
                type="password" 
                value={confirmPassword}
                onChange={e => setConfirmPassword(e.target.value)}
                />
            </Form.Group>
            <Alert key='danger' variant='danger' hidden={passwordMatch}>
            The passwords do not match!
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
    )
    
}
export default ChangePassword