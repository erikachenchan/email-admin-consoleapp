package com.uwe;

import java.util.ArrayList;

public class Email {

    private ArrayList<Person> personArrayList;

    public Email() {
        this.personArrayList = new ArrayList<>();
    }

    // Method to add a Person object to the emailList
    public void addList(Person person) {
        personArrayList.add(person);
    }

    // Method to print details of employees in the arrayList
    public void printUserInfo() {
        if (personArrayList.isEmpty()) {
            System.out.println("The list currently empty!");
        } else {
            System.out.println("Printing Employees...");
            for (Person person : personArrayList) {
                System.out.println(person);
            }
        }
    }

    // Method to update employee information based on email address
    public void updateEmployee(String newFirstName, String newLastName, String newDepartment) {
        for (Person person : personArrayList) {
            // Update the information of the matching employee
            person.setFirstName(newFirstName);
            person.setLastName(newLastName);
            person.setDepartment(newDepartment);

            System.out.println("Employee updated successfully!");
            return; // Exit the loop once the update is done
        }
        // If the loop completes without finding a matching email, print a message
        System.out.println("Employee not found. Please enter a valid email address.");
    }

    // Method to retrieve a List person objects whose username name match a string input.
    // a line declares a method named getEmployeesByUsername that takes a String parameter username and returns an ArrayList of Person objects.
    public ArrayList<Person> getEmployeesByUsername(String username) {
        // This line initialises a new ArrayList named matchingEmployees. This  list will be used to store the Person objects whose username match a string input.
        ArrayList<Person> matchingEmployees = new ArrayList<>();
        // For loop to iterates over each "Person" object in personArrayList
        for (Person person : personArrayList) {
            // If else condition checks if the username of the current person object (retrieved using getUsername() matches the specified username in a case-insensitive manner using equalsIgnoreCase().
            if (person.getUsername().equalsIgnoreCase(username)) {
                // If the condition is true (i.e., the username match), the current Person object is added to the matchingEmployees list using the add method.
                matchingEmployees.add(person);
            }
        }
        // This marks the end of the for-each loop. The loop iterates through all Person objects in personArrayList to find those with matching username names.
        return matchingEmployees;
    }

    // Method to delete employee
    public void deleteEmployeeByUsername(String uName) {
        // Iterate through the personArrayList to find the person with the matching username name
        for (Person person : personArrayList) {
            if (person.getUsername().equalsIgnoreCase(uName)) {
                // Remove the matching person from the list
                personArrayList.remove(person);
                System.out.println("Employee deleted successfully!");

                return; // Exit the loop once the deletion is done
            }
        }
    }
}

