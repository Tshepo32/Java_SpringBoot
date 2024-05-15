package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;


public class ContactFactory {
    public static Contact buildContact(String email, long mobile, long workTelephone) {
        // check if valid email - regex or apache commons
        if (!Helper.isValidEmailAddress(email))
            return null;

        if (Helper.isNullorEmpty(String.valueOf(mobile)) || Helper.isNullorEmpty(String.valueOf(workTelephone)))
            return null;

        return new Contact.Builder().setEmail(email)
                .setMobile(mobile)
                .setWorkTelephone(workTelephone)
                .build();
    }
}
