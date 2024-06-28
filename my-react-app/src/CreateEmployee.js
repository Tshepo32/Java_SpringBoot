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
        fetch('http://localhost:8080/exercise/employee/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(employee)
        })
            .then((response) => response.json())
            .then((data) => console.log(data))
            .catch((error) => console.error('Error:', error));
    };

    return (
        <div className="form-container">
            <form onSubmit={handleSubmit}>
                <label>
                    Employee Number:
                    <input type="text" name="employeeNumber" value={employee.employeeNumber} onChange={handleChange} />
                </label>
                <label>
                    First Name:
                    <input type="text" name="firstName" value={employee.firstName} onChange={handleChange} />
                </label>
                <label>
                    Last Name:
                    <input type="text" name="lastName" value={employee.lastName} onChange={handleChange} />
                </label>
                <label>
                    Email:
                    <input type="text" name="email" value={employee.email} onChange={handleChange} />
                </label>
                <label>
                    Mobile:
                    <input type="text" name="mobile" value={employee.mobile} onChange={handleChange} />
                </label>
                <label>
                    Work Telephone:
                    <input type="text" name="workTelephone" value={employee.workTelephone} onChange={handleChange} />
                </label>
                <button type="submit">Create Employee</button>
            </form>
        </div>
    );
};

export default CreateEmployee;
