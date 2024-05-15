package za.ac.cput.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullorEmpty(String s) {
        if (s == null || s.isEmpty())
            return true;
        return false;
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

}
