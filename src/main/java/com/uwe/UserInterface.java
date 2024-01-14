package com.uwe;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Email emailList;
    private Scanner scanner;

    public UserInterface(Email emailList, Scanner scanner) {
        this.emailList = emailList;
        this.scanner = scanner;
    }

    public void menuDisplay() {
        System.out.println("");
        System.out.println("==== Welcome to UWE Staff portal ====");
        System.out.println(" 1 - Create New Email");
        System.out.println(" 2 - Display All Employees Emails");
        System.out.println(" 3 - Update Employee Email details");
        System.out.println(" 4 - Delete Employee Email");
        System.out.println(" 5 - Update Employee Password");
        System.out.println(" 0 - Exit");

    }

    public void exitMessage() {
        System.out.println("Exiting...");
    }

    public void addEmployee() {
        System.out.println("Enter university id");
        String username = scanner.nextLine();
        String generatedUsername = generateUserName(username);

        System.out.println("Enter first name: ");
        String userFirstName = scanner.nextLine();

        System.out.println("Enter last name : ");
        String userLastName = scanner.nextLine();

        System.out.println("Enter Department");
        String userDepartment = scanner.nextLine();

        System.out.println("Enter the number of password you want from 1-78");
        int userPasswordGenInput = Integer.parseInt(scanner.nextLine());
        String generatedPassword = randomPassword(userPasswordGenInput);

        // Create a Person object with the provided input
        Person person = new Person(generatedUsername, userFirstName, userLastName, userDepartment, generatedPassword);

        // Add the Person object to the emailList
        emailList.addList(person);
        System.out.println("New employee has been added!");
    }

    public void printAllDetails() {
        this.emailList.printUserInfo();
    }

    public String randomPassword(int length) {
        // Define a string containing characters that can be used in the password
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";

        // Create an array `passwordChar` to  store the characters of the generated password with a length specified by the `length` param.
        char[] passwordChar = new char[length];

        // Iterate through the array to fill it with random characters (max password length is 10)
        for (int i = 0; i < length; i++) {
            // Generate a random index to pick a character from the passwordSet
            int rand = (int) (Math.random() * passwordSet.length());
            // Assign the randomly selected character to the current position in the passwordChar array
            passwordChar[i] = passwordSet.charAt(rand);
        }

        // Convert the character array to a String and return the generated password
        return new String(passwordChar);
    }

    // Method for updating employees
    public void updateEmployeeDetails() {
        System.out.println("Enter the username of the employee you want to update: ");
        String uName = scanner.nextLine();

        // Check if there is only one employee with the specified username
        ArrayList<Person> matchingEmployees = emailList.getEmployeesByUsername(uName);

        if (matchingEmployees.size() == 1) {


            System.out.println("Enter new first name: ");
            String newFirstName = scanner.nextLine();

            System.out.println("Enter new last name: ");
            String newLastName = scanner.nextLine();

            System.out.println("Enter new Department: ");
            String newDepartment = scanner.nextLine();

            // Update the employee information
            emailList.updateEmployee(newFirstName, newLastName, newDepartment);

        } else {
            // Return a message stating that no employees found with the specified first name
            System.out.println("No employee found with the specified first name. Please try again!");
        }
    }

    private void deleteEmployee() {
        System.out.println("Enter the username of the employee you want to delete");
        String uNameInput = scanner.nextLine();

        // The code uses the getEmployeesByUsername method of the Email class to retrieve a list of employees whose username match the user's input. This method returns an ArrayList<Person> containing all employees with the specified username.
        ArrayList<Person> matchingEmployees = emailList.getEmployeesByUsername(uNameInput);
        // The code checks if there is exactly one employee in the matchingEmployees list. If there is only one match, it calls the deleteEmployeeByUsername method of the Email class, passing the first name as an argument to delete that specific employee.
        if (matchingEmployees.size() == 1) {
            emailList.deleteEmployeeByUsername(uNameInput);
        } else {
            System.out.println("Employee not found. Please enter a valid username of employee you want to remove!");

        }
    }

    private String generateUserName(String username) {
        String universityId = "UWES";

        return new String(universityId + username);
    }

    public void updateEmployeePassword() {
        System.out.println("Type the username of the UWE staff: ");
        String uNameInput = scanner.nextLine();

        ArrayList<Person> matchPerson = emailList.getEmployeesByUsername(uNameInput);

        if (matchPerson.size() == 1) {
            System.out.println("Enter a new password: ");
            String newPass = scanner.nextLine();

            System.out.println("Confirm a new password: ");
            String confirmPass = scanner.nextLine();

            if (newPass.equals(confirmPass)) {
                emailList.updatePassword(confirmPass);
            } else {
                System.out.println("Password does not match, try again!");
            }
        }

    }

    public void start() {
        while (true) {
            menuDisplay();
            try {
                int userInputCommand = Integer.parseInt(scanner.nextLine());

                if (userInputCommand == 0) {
                    exitMessage();
                    break;
                }

                if (userInputCommand == 1) {
                    addEmployee();
                }

                if (userInputCommand == 2) {
                    printAllDetails();
                }

                if (userInputCommand == 3) {
                    updateEmployeeDetails();
                }

                if (userInputCommand == 4) {
                    deleteEmployee();
                }

                if (userInputCommand == 5) {
                    updateEmployeePassword();
                }

            } catch (Exception e) {
                System.out.println("Try again! Enter valid command! ");
                System.out.println();
            }
        }
    }
}
