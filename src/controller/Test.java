package controller;

import model.Employee;
import java.io.IOException;
import static controller.FilmController.downloadFilmInfo;
import static controller.HelperClass.isEmailAddressValid;

public class Test {

    public static void main(String[] args) throws IOException {

        Employee bob = new Employee("Bob","Dylan","bob@dylan.com");

        if (isEmailAddressValid(bob.getEmailAddress())) {
            System.out.println(bob.getEmailAddress() + " is a valid email address");
        } else {
            System.out.println(bob.getEmailAddress() + " is not a valid email address");
        }

        System.out.println(downloadFilmInfo("Star Wars",2015));
    }
}