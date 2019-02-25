package controller;

import org.apache.commons.validator.routines.EmailValidator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class HelperClass {

   /* public static boolean isEmailAddressValid(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }*/

    public static boolean isEmailAddressValid(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        boolean validEmail = validator.isValid(email);
        return validEmail;
    }
}
