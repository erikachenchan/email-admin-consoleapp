package com.uwe;

public class Person {

    private String username;
    private String firstName;
    private String lastName;
    private String department;
    private String companySuffix = ".uwe.com";

    private String password;

    public Person(String username, String firstName, String lastName, String department, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompanySuffix() {
        return companySuffix;
    }

    public void setCompanySuffix(String companySuffix) {
        this.companySuffix = companySuffix;
    }

    // firstName.lastName@department.company.com
    @Override
    public String toString() {
        return "Email: {" + "username= " + username + " | " + firstName + "." + lastName + "@" + department + companySuffix + " |  email password =" + password + '}';
    }


}
