package controller;

import org.apache.commons.validator.routines.EmailValidator;
import java.lang.String;



public class HelperClass {

    public static boolean isEmailAddressValid(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        boolean validEmail = validator.isValid(email);
        return validEmail;
    }

    public static String replaceSpacesInString(String stringToFormat, String replacement) {
        String ret = (stringToFormat.replaceAll("\\s+", replacement));
        return ret;
    }

    public static String parseStringByChar(String str) {
        str = str.substring(str.indexOf(","));
        str = str.substring(1, str.indexOf(":"));
        return str;
    }
}

    /*public static String[] stringToArray(String str){
        String[] ary = str.split("\",\"");
        for (String str1 : ary){
            String[] keyValue = str1.split("\":\"");
            Film f = new Film();
            if(keyValue[0].contains("Year")){
                f.setTitle(keyValue[1]);
            }
            System.out.println(f);
            System.out.println("Key: " + keyValue[0]);
            System.out.println("Value: " + keyValue[1]);
        }
        return ary;*/
