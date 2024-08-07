import React, { useState } from 'react';
import EmployeeService from './EmployeeService';

const AddEmployee = () => {
    const [employee, setEmployee] = useState({
        employeeNumber: '',
        firstName: '',
        lastName: '',
        email: '',
        mobile: '',
        workTelephone: '',
    });

    const [message, setMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEmployee({
            ...employee,
            [name]: value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await EmployeeService.addEmployee(employee);
            setMessage('Employee added successfully!');
            setEmployee({ employeeNumber: '', firstName: '', lastName: '', email: '', mobile: '', workTelephone: '' }); // Clear form
        } catch (error) {
            console.error('There was an error adding the employee!', error);
            setMessage('Failed to add employee.');
        }
    };

    return (
        <div>
            <h1>Add Employee</h1>
            {message && <p>{message}</p>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Employee Number:</label>
                    <input type="text" name="employeeNumber" value={employee.employeeNumber} onChange={handleChange} required />
                </div>
                <div>
                    <label>First Name:</label>
                    <input type="text" name="firstName" value={employee.firstName} onChange={handleChange} required />
                </div>
                <div>
                    <label>Last Name:</label>
                    <input type="text" name="lastName" value={employee.lastName} onChange={handleChange} required />
                </div>
                <div>
                    <label>Email:</label>
                    <input type="email" name="email" value={employee.email} onChange={handleChange} required />
                </div>
                <div>
                    <label>Mobile:</label>
                    <input type="text" name="mobile" value={employee.mobile} onChange={handleChange} required />
                </div>
                <div>
                    <label>Work Telephone:</label>
                    <input type="text" name="workTelephone" value={employee.workTelephone} onChange={handleChange} required />
                </div>
                <button type="submit">Add Employee</button>
            </form>
        </div>
    );
};

export default AddEmployee;
