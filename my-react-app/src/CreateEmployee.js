import React, { useState } from 'react';
import './App.css';

const CreateEmployee = () => {
    const [employee, setEmployee] = useState({
        employeeNumber: '',
        firstName: '',
        lastName: '',
        email: '',
        mobile: '',
        workTelephone: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEmployee((prevEmployee) => ({
            ...prevEmployee,
            [name]: value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Create contact object
        const contact = {
            email: employee.email,
            mobile: employee.mobile,
            workTelephone: employee.workTelephone
        };

        // Create employee object with embedded contact
        const newEmployee = {
            employeeNumber: employee.employeeNumber,
            firstName: employee.firstName,
            lastName: employee.lastName,
            contact: contact
        };

        fetch('http://localhost:8080/exercise/employee/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newEmployee) // Sending the newEmployee object which includes contact
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                // Optionally handle the response
            })
            .catch((error) => {
                console.error('Error:', error);
                // Optionally handle the error
            });
    };

    return (
        <div className="form-container">
            <form onSubmit={handleSubmit}>
                <label>
                    Employee Number:
                    <input type="text" name="employeeNumber" value={employee.employeeNumber} onChange={handleChange} required />
                </label>
                <label>
                    First Name:
                    <input type="text" name="firstName" value={employee.firstName} onChange={handleChange} required />
                </label>
                <label>
                    Last Name:
                    <input type="text" name="lastName" value={employee.lastName} onChange={handleChange} required />
                </label>
                <label>
                    Email:
                    <input type="email" name="email" value={employee.email} onChange={handleChange} required />
                </label>
                <label>
                    Mobile:
                    <input type="text" name="mobile" value={employee.mobile} onChange={handleChange} required />
                </label>
                <label>
                    Work Telephone:
                    <input type="text" name="workTelephone" value={employee.workTelephone} onChange={handleChange} required />
                </label>
                <button type="submit">Create Employee</button>
            </form>
        </div>
    );
};

export default CreateEmployee;
