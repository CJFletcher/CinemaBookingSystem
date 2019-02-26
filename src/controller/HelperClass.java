package controller;

import org.apache.commons.validator.routines.EmailValidator;
import java.lang.String;

public class HelperClass {

    public static boolean isEmailAddressValid(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        boolean validEmail = validator.isValid(email);
        return validEmail;
    }

    public static String replaceSpacesInString(String stringToFormat,String replacement) {
        String ret = (stringToFormat.replaceAll("\\s+",replacement));
        return ret;
    }

    public static String parseStringByChar(String str){
        str = str.substring(str.indexOf("\"") + 1);
        str = str.substring(0, str.indexOf("\""));
        return str;
    }
}
