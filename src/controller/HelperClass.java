package controller;

import org.apache.commons.validator.routines.EmailValidator;
import java.lang.String;

public class HelperClass {

    public static boolean isEmailAddressValid(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        boolean validEmail = validator.isValid(email);
        return validEmail;
    }

    public static String replaceSpacesInString(String stringToFormat) {
        String ret = (stringToFormat.replaceAll("\\s+","+"));
        return ret;
    }
}
