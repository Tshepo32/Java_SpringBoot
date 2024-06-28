import React, { useState, useEffect } from 'react';

const GetAllEmployees = () => {
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/exercise/employee/getall')
            .then(response => response.json())
            .then(data => setEmployees(data))
            .catch(error => console.error('Error:', error));
    }, []);

    return (
        <div>
            <h2>All Employees</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>Employee Number</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Work Telephone</th>
                </tr>
                </thead>
                <tbody>
                {employees.map(employee => (
                    <tr key={employee.employeeNumber}>
                        <td>{employee.employeeNumber}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.contact ? employee.contact.email : '-'}</td>
                        <td>{employee.contact ? employee.contact.mobile : '-'}</td>
                        <td>{employee.contact ? employee.contact.workTelephone : '-'}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default GetAllEmployees;
