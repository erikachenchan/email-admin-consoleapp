package com.uwe;

import java.util.Scanner;

public class MainEmailApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Email email = new Email();
        UserInterface userInterface = new UserInterface(email, scanner);

        userInterface.start();

    }
}