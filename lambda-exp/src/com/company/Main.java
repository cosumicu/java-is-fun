package com.company;

public class Main {

    public static void main(String[] args) {

        String str = "string";

        int a = 10;
        int b = 5;

        MyInterface myInterface = (num1,num2) -> {
            int sum = num1 + num2;
            return sum;
        };

        System.out.println(myInterface.subtract(a, b));
    }
}
