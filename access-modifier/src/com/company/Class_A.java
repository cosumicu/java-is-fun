package com.company;

public class Class_A implements B, D{

    String reverseString(String string) {

        String reversedString = "";
        char emptyChar;

        for(int i = string.length() - 1; i >= 0; i--) {
            emptyChar = string.charAt(i);
            reversedString += emptyChar;
        }

        return reversedString;
    }

    public void call() {
        System.out.println("Call method");
    }

    @Override
    public void message() {
        D.super.message();
    }
}
