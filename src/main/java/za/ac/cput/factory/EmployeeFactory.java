package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

import java.util.concurrent.ThreadLocalRandom;

public class EmployeeFactory {

    // Create an Employee object with provided employee number, first name, and last name
    public static Employee buildEmployee(long employeeNumber, String firstName, String lastName, Contact contact) {
        if (Helper.isNullorEmpty(String.valueOf(employeeNumber)) ||
                Helper.isNullorEmpty(firstName) ||
                Helper.isNullorEmpty(lastName) ||
                contact == null)
            return null;

        return new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .build();
    }

    public static Employee buildEmployee(long employeeNumber, String firstName, String lastName, String email, long mobile, long workTelephone) {
        if (Helper.isNullorEmpty(String.valueOf(employeeNumber)) ||
                Helper.isNullorEmpty(firstName) ||
                Helper.isNullorEmpty(lastName))
            return null;

        if (!Helper.isValidEmailAddress(email))
            return null;

        if (Helper.isNullorEmpty(String.valueOf(mobile)) || Helper.isNullorEmpty(String.valueOf(workTelephone)))
            return null;

        Contact contact = ContactFactory.buildContact(email, mobile, workTelephone);

        return new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .build();
    }
}
