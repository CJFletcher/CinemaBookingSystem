package controller;

import model.Employee;
import static controller.HelperClass.isEmailAddressValid;

public class Test {

    public static void main(String[] args) {

        Employee bob = new Employee("Bob","Dylan","bob@dylan.com");

        if (isEmailAddressValid(bob.getEmailAddress())) {
            System.out.println(bob.getEmailAddress() + " is a valid email address");
        } else {
            System.out.println(bob.getEmailAddress() + " is not a valid email address");
        }
    }
}