package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choice;

        MobilePhone phone = new MobilePhone();

        while(true) {
            System.out.println("1. Default\n2. Choose how much load and what network");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    float load;
                    String network;
                    do {
                        System.out.println("Enter amount of load: ");
                        load = scan.nextFloat();
                        System.out.println("Enter network: ");
                        network = scan.next();

                        if (load < 0 || (network.charAt(0) != 's' || network.charAt(0) != 't' || network.charAt(0) != 'g'))
                            System.out.println("Invalid input.");
                    }
                    while (network.charAt(0) != 's' || network.charAt(0) != 't' || network.charAt(0) != 'g');

                    phone.setLoad(load);
                    phone.setNetwork(network.charAt(0));

            }
            System.out.println(phone.checkBalance());
            System.out.println(phone.getNetwork());
            while(true) {
                System.out.println("1. Check balance\n2. Call\n3. Text\n4. Reload\n5. Exit");
                choice = scan.nextInt();
                switch(choice) {
                    case 1:
                        System.out.println(phone.checkBalance());
                        break;
                    case 2:
                        System.out.println("Enter Minutes of call: ");
                        int minutes = scan.nextInt();
                        System.out.println("Enter Network: ");
                        String network = scan.next();
                        if()
                        phone.call(minutes, network.charAt(0));
                        break;
                    case 3:
                        System.out.println("Enter Length of text: ");
                        int length = scan.nextInt();
                        System.out.println("Enter Network: ");
                        network = scan.next();
                        phone.text(length, network.charAt(0));
                        break;
                    case 4:
                        System.out.println("Enter amount: ");
                        float amount = scan.nextFloat();
                        phone.reload(amount);
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid input!!");
                }
            }
        }
    }
}
