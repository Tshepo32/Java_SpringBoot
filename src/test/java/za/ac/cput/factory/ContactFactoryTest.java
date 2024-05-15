package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;


class ContactFactoryTest {

    @Test
    void buildContact() {
        Contact c = ContactFactory.buildContact("my@cput.com", 11584, 14587);
        assertNotNull(c);
        System.out.println(c.toString());
    }

    @Test
    void buildContactWithFail() {
        Contact c = ContactFactory.buildContact("mycput.com", 11584, 14587);
        assertNotNull(c);
        System.out.println(c.toString());
    }
}