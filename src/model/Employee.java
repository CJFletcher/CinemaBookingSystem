package model;

public class Employee extends User{
    private int employeeNumber;
    private String userType;

    public Employee(String firstName, String lastName, String emailAddress, String username, String password, int employeeNumber) {
        super(firstName, lastName, emailAddress, username, password);
        this.employeeNumber = employeeNumber;
        this.setUserType("Employee");
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
