package model;

public class Admin extends User {

    public Admin(String firstName, String lastName, String emailAddress, String username, String password) {
        super(firstName, lastName, emailAddress, username, password);
        this.setUserType("Admin");
    }
}
