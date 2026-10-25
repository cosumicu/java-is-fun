package com.company;

import com.package2.StringManip;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String string1, string2 = null;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 2 String:\nString 1: ");
        string2 = scan.nextLine();
        System.out.println("String 2: ");
        string1 = scan.nextLine();

        String string3 = StringManip.stringConcat(string1, string2);

        System.out.println("Length of 2 strings: " + StringManip.stringLength(string1, string2));
        System.out.println("Concat 2 strings: " + string3);
        System.out.println("Upper Case: " + StringManip.stringUpperCase(string3));


    }


}
