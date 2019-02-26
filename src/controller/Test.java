package controller;

import model.Employee;
import model.Film;

import java.io.IOException;
import java.time.LocalDate;

import static controller.FilmController.downloadFilmInfo;
import static controller.HelperClass.isEmailAddressValid;
import static controller.HelperClass.parseStringByChar;

public class Test {

    public static void main(String[] args) throws IOException {

        Film avatar = new Film("Avatar","Bop" ,LocalDate.of( 2019 , 1 , 1 ) ,LocalDate.of( 2019 , 1 , 31 ),126,1);
        System.out.println(avatar);

        Employee bob = new Employee("Bob","Dylan","bob@dylan.com");

        if (isEmailAddressValid(bob.getEmailAddress())) {
            System.out.println(bob.getEmailAddress() + " is a valid email address");
        } else {
            System.out.println(bob.getEmailAddress() + " is not a valid email address");
        }

        System.out.println(downloadFilmInfo("Star Wars",2015));
        System.out.println((parseStringByChar(downloadFilmInfo("Star Wars",2017),":")));

    }
}