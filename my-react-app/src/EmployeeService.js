// src/EmployeeService.js
import axios from 'axios';

const BASE_URL = 'http://localhost:8080/employee';

class EmployeeService {
    static async addEmployee(employee) {
        try {
            const response = await axios.post(`${BASE_URL}/create`, employee);
            return response.data;
        } catch (error) {
            throw error;
        }
    }
}

export default EmployeeService;
