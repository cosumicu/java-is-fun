package com.company;

public class Fraction {
    private boolean isValid = true;
    private int numerator = 0;
    private int denominator = 1;
    Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            isValid = false;
            System.out.println("Invalid fraction, denominator can't be zero");
            return;
        }
        int sign = numerator*denominator;
        if (sign < 0) {
            sign = -1;
        } else {
            sign = +1;
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        int gcd = gcd(numerator, denominator);
        this.numerator = sign*numerator/gcd;
        this.denominator = denominator/gcd;
    }
    static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public boolean isValid() {
        return isValid;
    }

    public void add(Fraction f) {
        if (!isValid || !f.isValid() ) {
            System.out.println("Cant work with an invalid fraction");
            return;
        }
        int myNum = this.numerator;
        int myDen = this.denominator;
        int othNum = f.getNumerator();
        int othDen = f.getDenominator();
        int newDeno = myDen*othDen;
        myNum = myNum*othDen;
        othNum = othNum*myDen;
        int newNum = myNum + othNum;
        int sign;
        if (newNum < 0) {
            sign = -1;
        }
        else {
            sign = +1;
        }
        newNum = Math.abs(newNum);
        int gcd = gcd(newNum, newDeno);
        this.numerator = sign*newNum/gcd;
        this.denominator = newDeno/gcd;
    }

    public static Fraction add(Fraction first, Fraction second) {
        Fraction fRet = new Fraction(first.getNumerator(), first.getDenominator());
        fRet.add(second);
        return fRet;
    }

    public void subtract(Fraction f) {
        if (!isValid || !f.isValid() ) {
            System.out.println("Cant work with an invalid fraction");
            return;
        }
        int myNum = this.numerator;
        int myDen = this.denominator;
        int othNum = f.getNumerator();
        int othDen = f.getDenominator();
        int newDeno = myDen*othDen;
        myNum = myNum*othDen;
        othNum = othNum*myDen;
        int newNum = myNum - othNum;
        int sign;
        if (newNum < 0) {
            sign = -1;
        }
        else {
            sign = +1;
        }
        newNum = Math.abs(newNum);
        int gcd = gcd(newNum, newDeno);
        this.numerator = sign*newNum/gcd;
        this.denominator = newDeno/gcd;
    }

    public static Fraction subtract(Fraction first, Fraction second) {
        Fraction fRet = new Fraction(first.getNumerator(), first.getDenominator());
        fRet.subtract(second);
        return fRet;
    }

    public void multiply(Fraction f) {
        if (!isValid || !f.isValid() ) {
            System.out.println("Cant work with an invalid fraction");
            return;
        }
        int myNum = this.numerator;
        int myDen = this.denominator;
        int othNum = f.getNumerator();
        int othDen = f.getDenominator();
        int newDeno = myDen*othDen;
        int newNum = myNum*othNum;
        int sign;
        if (newNum < 0) {
            sign = -1;
        }
        else {
            sign = +1;
        }
        newNum = Math.abs(newNum);
        int gcd = gcd(newNum, newDeno);
        this.numerator = sign*newNum/gcd;
        this.denominator = newDeno/gcd;
    }
    public static Fraction multiply(Fraction first, Fraction second) {
        Fraction fRet = new Fraction(first.getNumerator(), first.getDenominator());
        fRet.multiply(second);
        return fRet;
    }

    public void divide(Fraction f) {
        if (!isValid || !f.isValid() ) {
            System.out.println("Cant work with an invalid fraction");
            return;
        }
        int myNum = this.numerator;
        int myDen = this.denominator;
        int othSign = f.getNumerator();
        if (othSign < 0) {
            othSign = -1;
        }
        else {
            othSign = +1;
        }
        int othNum = othSign * f.getDenominator();
        int othDen = Math.abs(f.getNumerator());
        int newDeno = myDen*othDen;
        int newNum = myNum*othNum;
        int sign;
        if (newNum < 0) {
            sign = -1;
        }
        else {
            sign = +1;
        }
        newNum = Math.abs(newNum);
        int gcd = gcd(newNum, newDeno);
        this.numerator = sign*newNum/gcd;
        this.denominator = newDeno/gcd;
    }
    public static Fraction divide(Fraction first, Fraction second) {
        Fraction fRet = new Fraction(first.getNumerator(), first.getDenominator());
        fRet.divide(second);
        return fRet;
    }

    @Override
    public String toString() {
        return (numerator + "/" +denominator);
    }

    public int compareTo(Fraction f) {
        if (!isValid || !f.isValid() ) {
            System.out.println("Cant work with an invalid fraction");
            return 999;
        }
        int myNum = this.numerator;
        int myDen = this.denominator;
        int othNum = f.getNumerator();
        int othDen = f.getDenominator();
        if (myNum == othNum && myDen == othDen) {
            return 0;
        }
        myNum = myNum*othDen;
        othNum = othNum*myDen;
        if (myNum < othNum) {
            return -1;
        }
        else {
            return 1;
        }
    }
    public static boolean greaterThan(Fraction first, Fraction second) {
        Fraction fRet = new Fraction(first.getNumerator(), first.getDenominator());
        if (fRet.compareTo(second) == 1) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean lessThan(Fraction first, Fraction second) {
        Fraction fRet = new Fraction(first.getNumerator(), first.getDenominator());
        if (fRet.compareTo(second) == -1) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean equals(Fraction first, Fraction second) {
        Fraction fRet = new Fraction(first.getNumerator(), first.getDenominator());
        if (fRet.compareTo(second) == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        fraction1.add(fraction2);
        System.out.println(fraction1);
        fraction1 = new Fraction(1, 2);
        fraction1.subtract(fraction2);
        System.out.println(fraction1);
        fraction1 = new Fraction(1, 2);
        fraction1.multiply(fraction2);
        System.out.println(fraction1);
        fraction1 = new Fraction(1, 2);
        fraction1.divide(fraction2);
        System.out.println(fraction1);
        fraction1 = new Fraction(1, 2);
        System.out.println(fraction1.compareTo(fraction1));
        System.out.println(fraction1.compareTo(fraction2));
        System.out.println(fraction2.compareTo(fraction1));

        System.out.println(Fraction.add(fraction1, fraction2));
        System.out.println(Fraction.subtract(fraction1, fraction2));
        System.out.println(Fraction.multiply(fraction1, fraction2));
        System.out.println(Fraction.divide(fraction1, fraction2));
        System.out.println(Fraction.greaterThan(fraction1, fraction2));
        System.out.println(Fraction.lessThan(fraction1, fraction2));
        System.out.println(Fraction.equals(fraction1, fraction2));

    }
}