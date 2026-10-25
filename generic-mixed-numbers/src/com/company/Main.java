package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        MixedNumber mn1 = new MixedNumber<Float>(0.25f,0.25f);
        MixedNumber mn2 = new MixedNumber<Long>(23L, 23L);
        MixedNumber mn3 = new MixedNumber<Double>(11d, 18d, 18d);



        System.out.println(mn1.getWholeNumber() + " " + mn1.getNumerator() + " " + mn1.getDenominator());
        System.out.println(mn2.getWholeNumber() + " " + mn2.getNumerator() + " " + mn2.getDenominator());
        System.out.println(mn3.getWholeNumber() + " " + mn3.getNumerator() + " " + mn3.getDenominator());


































//        System.out.println("Fraction mn1 = new MixedNumber<Float>(0.25f);");
//        System.out.println("whole num:" + mn1.getWholeNumber());
//        System.out.println("numerator:" + mn1.getNumerator());
//        System.out.println("denominator:" + mn1.getDenominator());
//        System.out.println(mn1.getWholeNumber() + " " + mn1.getNumerator() + "/" + mn1.getDenominator());
//
//
//        System.out.println("Fraction mn2 = new MixedNumber<Long>(34L, 6L);");
//        System.out.println("whole num:" + mn2.getWholeNumber());
//        System.out.println("numerator:" + mn2.getNumerator());
//        System.out.println("denominator:" + mn2.getDenominator());
//        System.out.println(mn2.getWholeNumber() + " " + mn2.getNumerator() + "/" + mn2.getDenominator());
//
//        System.out.println("Fraction mn3 = new MixedNumber<Double>(11d, 18d, 10d);");
//        System.out.println("whole num:" + mn3.getWholeNumber());
//        System.out.println("numerator:" + mn3.getNumerator());
//        System.out.println("denominator:" + mn3.getDenominator());
//        System.out.println(mn3.getWholeNumber() + " " + mn3.getNumerator() + "/" + mn3.getDenominator());
//
//        System.out.println("ADDITION");
//        System.out.println("mn1 + mn2 = MixedNumber(whole = 5, numerator = 11, denominator = 12)");
//        System.out.println("whole: " + MixedNumber.addMixedNumber(mn1 , mn2).getWholeNumber());
//        System.out.println("numerator: " + MixedNumber.addMixedNumber(mn1 , mn2).getNumerator());
//        System.out.println("denominator: " + MixedNumber.addMixedNumber(mn1 , mn2).getDenominator());
//        System.out.println("Mixed number: "+MixedNumber.addMixedNumber(mn1,mn2).getWholeNumber() +
//                " " + MixedNumber.addMixedNumber(mn1,mn2).getNumerator() + "/" + MixedNumber.addMixedNumber(mn1,mn2).getDenominator());
//
//        System.out.println("SUBTRACTION");
//        System.out.println("mn3 - mn2 = MixedNumber(whole = 7, numerator = 2, denominator = 15)");
//        System.out.println("whole: " + MixedNumber.subtractMixedNumber(mn3 , mn2).getWholeNumber());
//        System.out.println("numerator: " + MixedNumber.subtractMixedNumber(mn3 , mn2).getNumerator());
//        System.out.println("denominator: " + MixedNumber.subtractMixedNumber(mn3 , mn2).getDenominator());
//        System.out.println("Mixed number: "+MixedNumber.subtractMixedNumber(mn3,mn2).getWholeNumber() +
//                " " + MixedNumber.subtractMixedNumber(mn3,mn2).getNumerator() + "/" + MixedNumber.subtractMixedNumber(mn3,mn2).getDenominator());
//
//        System.out.println("MULTIPLICATION");
//        System.out.println("mn3 * mn1 = MixedNumber(whole = 3, numerator = 1, denominator = 5)");
//        System.out.println("whole: " + MixedNumber.multiplyMixedNumber(mn3 , mn1).getWholeNumber());
//        System.out.println("numerator: " + MixedNumber.multiplyMixedNumber(mn3 , mn1).getNumerator());
//        System.out.println("denominator: " + MixedNumber.multiplyMixedNumber(mn3 , mn1).getDenominator());
//        System.out.println("Mixed number: "+MixedNumber.multiplyMixedNumber(mn3,mn1).getWholeNumber() +
//                " " + MixedNumber.multiplyMixedNumber(mn3,mn1).getNumerator() + "/" + MixedNumber.multiplyMixedNumber(mn3,mn1).getDenominator());
//
//        System.out.println("DIVISION");
//        System.out.println("mn2 / mn3 = MixedNumber(whole = 0, numerator = 85, denominator = 192)");
//        System.out.println("whole: " + MixedNumber.divideMixedNumber(mn2 , mn3).getWholeNumber());
//        System.out.println("numerator: " + MixedNumber.divideMixedNumber(mn2 , mn3).getNumerator());
//        System.out.println("denominator: " + MixedNumber.divideMixedNumber(mn2 , mn3).getDenominator());
//        System.out.println("Mixed number: "+MixedNumber.divideMixedNumber(mn2,mn3).getWholeNumber() +
//                " " + MixedNumber.divideMixedNumber(mn2,mn3).getNumerator() + "/" + MixedNumber.divideMixedNumber(mn2,mn3).getDenominator());

    }
}