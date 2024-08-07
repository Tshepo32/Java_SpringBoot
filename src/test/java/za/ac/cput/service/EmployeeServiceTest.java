package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    private static Employee employee1;
    private static Employee employee2;

    @BeforeEach
    void setUp() {
        employee1 = EmployeeFactory.buildEmployee(8795, "laffe", "Maleo", "Matin@cput.ac.za",523658, 25954);
        assertNotNull(employee1);
        System.out.println(employee1);

        employee2 = EmployeeFactory.buildEmployee(8755, "big", "Maleho", "moholo@gmail.com", 32589, 59846);
        assertNotNull(employee2);
        System.out.println(employee2);


    }

    @Test
    void create() {
        Employee created1 = employeeService.create(employee1);
        assertNotNull(created1);
        System.out.println(created1);

        Employee created2 = employeeService.create(employee2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void read() {
        Employee rd = employeeService.read(employee1.getEmployeeNumber());
        assertNotNull(rd);
        System.out.println(rd);
    }

    @Test
    void update() {
        Contact editedContact = new Contact.Builder().copy(employee1.getContact())
                .setMobile(584756).build();
        assertNotNull(editedContact);
        Employee editedEmployee = new Employee.Builder().copy(employee1)
                .setContact(editedContact).build();
        assertNotNull(editedEmployee);
        Employee edited = employeeService.update(editedEmployee);
        assertNotNull(edited);
        System.out.println(edited);
    }

    @Test
    void getall() {
        System.out.println(employeeService.getall());
    }
}