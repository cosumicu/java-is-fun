package com.company;

import java.lang.constant.Constable;

import static java.lang.String.valueOf;

public class Fraction{

    private int numerator, denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(Number whole, Number numerator, Number denominator) {
        try{
            String a = String.valueOf(numerator);
            String[] b = a.split("\\.");
            this.numerator = Integer.parseInt(b[0]);
            a = String.valueOf(denominator);
            b = a.split("\\.");
            this.denominator = Integer.parseInt(String.valueOf(b[0]));
        } catch(NumberFormatException ex){ // handle your exception

            throw new NumberFormatException();
        }

    }

    // Utility
//    public <T extends Number> Constable convertDecimalToFraction(Object num) {
//        String a = valueOf(num);
//        double b = Double.parseDouble(a);
//
//        int whole = (int) b;
//        double decimal = Double.parseDouble(a) - whole;
//
//        String strDecimal = valueOf(decimal);
//        String den = "";
//        for(int i = 0; i < strDecimal.length() - 2; ++i) {
//            den += "0";
//        }
//        den = "1" + den;
//
//        int Denominator = Integer.parseInt(den);
//        int Numerator = Integer.parseInt(a.replace(".", ""));
//
//        int gcd = gcd(Numerator, Denominator);
//
//        this.denominator = Denominator/gcd;
//        this.numerator = (Numerator/gcd) % (Denominator/gcd);
//
//        return whole;
//    }

    public static int getWholeFraction(Fraction frac) {
        int counter = 0;
        while(frac.numerator >= frac.denominator) {
            frac.numerator -= frac.denominator;
            counter++;
        }
        return counter;
    }

    public static int gcf(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return (gcf(b, a % b));
        }
    }

    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);

    }

    public static int lcm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    public static void simplify(MixedNumber frac)
    {
        int d;
        d = gcd(frac.getNumerator(), frac.getDenominator());

        if(frac.getNumerator() >= frac.getDenominator()) {
            frac.setNumerator(frac.getNumerator() % frac.getDenominator());
        }
        else
            frac.setNumerator(frac.getNumerator()/d);

        frac.setDenominator(frac.getDenominator()/d);

    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}
