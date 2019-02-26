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

    public static String parseStringByChar(String stringToParse,String charsToParseBy){
        String string = stringToParse;
        String[] parts = string.split(charsToParseBy);
        String part1 = parts[1];
        String part2 = parts[1];
        return part1;
    }
}
