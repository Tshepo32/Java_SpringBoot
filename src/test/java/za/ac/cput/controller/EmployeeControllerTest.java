package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/exercise/employee";
    private static Employee employee;

    @BeforeAll
    public static void setup() {
        employee = EmployeeFactory.buildEmployee(5488, "Bafana", "Cape", "Cape@cput.com", 5689, 5487);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Employee employeeSaved = postResponse.getBody();
        assertEquals(employee.getEmployeeNumber(), employeeSaved.getEmployeeNumber());
        System.out.println("Saved data: " + employeeSaved);
    }

    @Test
    void read() {
    }

    @Test
    void getall() {
    }
}