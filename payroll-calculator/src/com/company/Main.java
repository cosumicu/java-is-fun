package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Regular Employee
//          salary is the sum of:
//              [1] basic pay (product of the number of days worked and daily rate)
//              [2] overtime pay (product of the number of overtime hours and 15% of the daily rate)
//          the deduction is from 20% of monthly salary (product of daily rate * 20)
//        Contractual Employee
//          salary is the product of days worked and daily rate (no overtime)
//          the deduction is a constant 1250

        Scanner scan = new Scanner(System.in);
        Employee employee = null;
        int choice;

        String firstName, midName, lastName;

        System.out.println("Enter your full name");
        System.out.println("First name: ");
        firstName = scan.nextLine();
        System.out.println("Middle name: ");
        midName = scan.nextLine();
        System.out.println("Last name: ");
        lastName = scan.nextLine();
        System.out.println("Welcome " + firstName);


        while(true) {
            System.out.println("[1] Regular Employee\n[2] Contractual Employee\n[3] Exit");
            System.out.println("User input: ");
            choice = scan.nextInt();
            if(choice == 1) { // Regular Employee
                employee = new Regular(firstName, midName, lastName);
                System.out.println("Enter your Daily Rate: ");
                float dailyRate;
                do{
                    dailyRate = scan.nextFloat();
                    if(dailyRate < 0)
                        System.out.println("invalid input. negative value.");
                }while(!(dailyRate >= 0));
                employee.setDailyRate(dailyRate);
                while(true) {
                    System.out.println("[1] Compute Salary\n[2] Compute Deduction\n[3] Back");
                    System.out.println("User input: ");
                    choice = scan.nextInt();
                    if(choice == 3)
                        break;
                    switch (choice) {
                        case 1 -> {
                            System.out.println("COMPUTE SALARY");
                            System.out.println("Number of Days Worked: ");
                            int days;
                            do {
                                days = scan.nextInt();
                                if (days < 0)
                                    System.out.println("invalid input. negative value.");
                            } while (!(days >= 0));
                            System.out.println("Overtime Hours: ");
                            int overtimeHours;
                            do {
                                overtimeHours = scan.nextInt();
                                if (overtimeHours < 0)
                                    System.out.println("invalid input. negative value.");
                            } while (!(overtimeHours >= 0));
                            System.out.println("Salary: " + employee.computeSalary(days, overtimeHours));
                        }
                        case 2 -> {
                            System.out.println("COMPUTE DEDUCTION");
                            employee.computeDeduction();
                            System.out.println("Deduction: " + Regular.showDeduction(employee));
                            System.out.println("Net Pay: " + employee.getNetPay());
                        }
                        default -> System.out.println("invalid input.");
                    }
                }
            } else if (choice == 2) { // Contractual Employee
                employee = new Contractual(firstName, midName, lastName);
                System.out.println("Enter your Daily Rate: ");
                float dailyRate;
                do {
                    dailyRate = scan.nextInt();
                    if (dailyRate < 0)
                        System.out.println("invalid input. negative value.");
                } while (!(dailyRate >= 0));
                employee.setDailyRate(dailyRate);
                while(true) {
                    System.out.println("[1] Compute Salary\n[2] Compute Deduction\n[3] Back");
                    System.out.println("User input: ");
                    choice = scan.nextInt();
                    if(choice == 3)
                        break;
                    switch (choice) {
                        case 1 -> {
                            System.out.println("COMPUTE SALARY");
                            System.out.println("Number of Days Worked: ");
                            int days;
                            do {
                                days = scan.nextInt();
                                if (days < 0)
                                    System.out.println("invalid input. negative value.");
                            } while (!(days >= 0));
                            System.out.println("Salary: " + employee.computeSalary(days, 0));
                        }
                        case 2 -> {
                            System.out.println("COMPUTE DEDUCTION");
                            System.out.println("Deduction: 1250.0"); // deduction is a constant 1250
                            System.out.println("Net Pay: " + employee.computeDeduction());
                        }
                        default -> System.out.println("invalid input.");
                    }
                }
            }
            else if(choice == 3) // Exit
                System.exit(0);
            else {
                System.out.println("invalid input.");
            }
        }
    }
}