package model;

public class Employee extends User{
    private int employeeNumber;
    private String department;
    private String userName;
    private String password;

    public Employee(String firstName, String lastName, String emailAddress, int employeeNumber, String department, String userName, String password) {
        super(firstName, lastName, emailAddress);
        this.employeeNumber = employeeNumber;
        this.department = department;
        this.userName = userName;

        this.password = password;
    }



    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
