package model;

public class Employee extends User{
    private int employeeNumber;
    private String department;
    private String userName;
    private String password;

    public Employee(String firstName, String lastName, String emailAddress) {
        super(firstName, lastName, emailAddress);
    }
}
