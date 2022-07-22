package com.example.marketplace;

import java.util.Scanner;

import static com.example.marketplace.MainMenu.MainSwitch;

public class SupportClass {

    public static int inputNum () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                int number = in.nextInt();
                return number;
            }
            System.out.println("Error, input int-value!");
        }
    }
    public static double inputDouble () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextDouble()) {
                double number = in.nextDouble();
                return number;
            }
            System.out.println("Error, input int-value!");
        }
    }
    public static String inputString () {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextLine()) {
                String name = in.nextLine();
                if (!name.isEmpty()){
                    return name;

                }
            }
            System.out.println(" Error, string is empty. ");
        }
    }

    public static void backToMain() {
        System.out.println(" For back to Main Menu enter any number.");
        int num = inputNum();
        MainSwitch();
    }
}
