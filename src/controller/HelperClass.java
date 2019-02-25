package controller;

import org.apache.commons.validator.routines.EmailValidator;


public class HelperClass {

    public static boolean isEmailAddressValid(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        boolean validEmail = validator.isValid(email);
        return validEmail;
    }
}
