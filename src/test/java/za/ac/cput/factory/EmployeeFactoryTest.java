package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    void buildEmployee() {
        Contact contact = ContactFactory.buildContact("Matin@cput.ac.za", 1987, 552125478);
        Employee e = EmployeeFactory.buildEmployee(154,"Lorens", "Maleo", contact);
        assertNotNull(e);
        System.out.println(e.toString());
    }

    @Test
    void testBuildEmployeeWithFail() {
        Contact contact = ContactFactory.buildContact("Matincput.ac.za", 1987, 552125478);
        Employee e = EmployeeFactory.buildEmployee(155, "Tshwanelo", "Reetseng", contact);
        assertNull(e);
        System.out.println(e.toString());
    }
}