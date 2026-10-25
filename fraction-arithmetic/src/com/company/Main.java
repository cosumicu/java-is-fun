package com.company;

public class Main {

    public static void main(String[] args) {

        //all non-zero values
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);

        //Instance related
        System.out.println("Instance related");
        System.out.println(fraction1.add(fraction2).toString());
        System.out.println(fraction1.subtract(fraction2).toString());
        System.out.println(fraction1.multiply(fraction2).toString());
        System.out.println(fraction1.divide(fraction2).toString());
        System.out.println(fraction1.add(fraction2).toString());
        System.out.println(fraction1.compareTo(fraction2));
        System.out.println(fraction2.compareTo(fraction1));

        //Class related
        System.out.println("Class related");
        System.out.println(Fraction.add(fraction1, fraction2).toString());
        System.out.println(Fraction.subtract(fraction1, fraction2).toString());
        System.out.println(Fraction.multiply(fraction1, fraction2).toString());
        System.out.println(Fraction.divide(fraction1, fraction2).toString());
        System.out.println(Fraction.greaterThan(fraction1, fraction2));
        System.out.println(Fraction.lessThan(fraction1, fraction2));
        System.out.println(Fraction.equals(fraction1, fraction2));
    }
}
