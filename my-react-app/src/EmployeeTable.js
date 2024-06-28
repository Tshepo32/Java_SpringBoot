import React from 'react';

const EmployeeTable = ({ employees }) => {
    return (
        <div>
            <h2>All Employees</h2>
            <table>
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

export default EmployeeTable;
