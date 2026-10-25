package com.company;

import java.lang.constant.Constable;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class MixedNumber<T extends Number> extends Fraction {
    private int wholeNumber;

    public MixedNumber(T num) {
        super();
        String strNum = String.valueOf(num);
        if (strNum.matches("^\\d+\\.\\d+"))
            this.wholeNumber = convertDecimalToFraction(strNum);
        else {
            String a = String.valueOf(num);
            String[] b = a.split("\\.");
            setNumerator(Integer.parseInt(b[0]));
        }
    }

    public MixedNumber(T numerator, T denominator) {
        String a = String.valueOf(numerator);
        String[] b = a.split("\\.");
        setNumerator(Integer.parseInt(b[0]));

        a = String.valueOf(denominator);
        b = a.split("\\.");
        setDenominator(Integer.parseInt(b[0]));

        simplifyMixedNumber(this);
    }

    public MixedNumber(T wholeNum, T numerator, T denominator) {
        String a = String.valueOf(numerator);
        String[] b = a.split("\\.");
        setNumerator(Integer.parseInt(b[0]));

        a = String.valueOf(denominator);
        b = a.split("\\.");
        setDenominator(Integer.parseInt(b[0]));

        a = String.valueOf(wholeNum);
        b = a.split("\\.");
        setWholeNumber(Integer.parseInt(b[0]));

        simplifyMixedNumber(this);
    }

    public static MixedNumber addMixedNumber(MixedNumber frac1, MixedNumber frac2) {

        int sumDenom = lcm(frac1.getDenominator(), frac2.getDenominator());
        frac1.setNumerator((frac1.getWholeNumber() * frac1.getDenominator() + frac1.getNumerator()));
        frac1.setWholeNumber(0);
        frac2.setNumerator((frac2.getWholeNumber() * frac2.getDenominator() + frac2.getNumerator()));
        frac2.setWholeNumber(0);
        int sumNum = ((frac1.getNumerator() * frac2.getDenominator()) + (frac2.getNumerator() * frac1.getDenominator()));
        int sumWhole = frac1.getWholeNumber() + frac2.getWholeNumber();

        MixedNumber sum = new MixedNumber(sumWhole, sumNum, sumDenom);
        simplify(sum);
        return sum;
    }

    public static MixedNumber subtractMixedNumber(MixedNumber frac1, MixedNumber frac2) {

        int difDenom = lcm(frac1.getDenominator(), frac2.getDenominator());
//        int difNum = difDenom/frac1.getDenominator()*frac1.getNumerator() - difDenom/frac2.getDenominator()*frac2.getNumerator();
        frac1.setNumerator((frac1.getWholeNumber() * frac1.getDenominator() + frac1.getNumerator()));
        frac1.setWholeNumber(0);
        frac2.setNumerator((frac2.getWholeNumber() * frac2.getDenominator() + frac2.getNumerator()));
        frac2.setWholeNumber(0);
        int difNum = (frac2.getDenominator() * (frac1.getWholeNumber() * frac1.getDenominator() + frac1.getNumerator())) - (frac1.getDenominator() * frac2.getNumerator());
        int difWhole = frac1.getWholeNumber() - frac2.getWholeNumber();
        MixedNumber dif = new MixedNumber(difWhole, difNum, difDenom);
        simplify(dif);
        return dif;
    }

    public static MixedNumber multiplyMixedNumber(MixedNumber frac1, MixedNumber frac2) {

        int productWhole = 0;
        int frac1num = (frac1.getWholeNumber() * frac1.getDenominator()) + frac1.getNumerator();
        int frac2num = (frac2.getWholeNumber() * frac2.getDenominator()) + frac2.getNumerator();

        int productNum = frac1num * frac2num;
        int productDenom = frac1.getDenominator() * frac2.getDenominator();

        if (productNum > productDenom) {
            productWhole = getWholeFraction(new Fraction(productNum, productDenom));
            productNum = productNum % productDenom;
            int gcf = gcf(productNum, productDenom);
            productNum /= gcf;
            productDenom /= gcf;
            ;
        }


        MixedNumber product = new MixedNumber(productWhole, productNum, productDenom);
        simplify(product);

        return product;
    }

    public static MixedNumber divideMixedNumber(MixedNumber frac1, MixedNumber frac2) {

        int quotientWhole = 0;
        int frac1num = (frac1.getWholeNumber() * frac1.getDenominator()) + frac1.getNumerator();
        int frac2num = (frac2.getWholeNumber() * frac2.getDenominator()) + frac2.getNumerator();

        int quotientNum = frac1num * frac2.getDenominator();
        int quotientDenom = frac1.getDenominator() * frac2num;

        if (quotientNum > quotientDenom) {
            quotientWhole = getWholeFraction(new Fraction(quotientNum, quotientDenom));
            quotientNum = quotientNum % quotientDenom;
            int gcf = gcf(quotientNum, quotientDenom);
            quotientNum /= gcf;
            quotientDenom /= gcf;
            ;
        }

        MixedNumber quotient = new MixedNumber(quotientWhole, quotientNum, quotientDenom);
        simplify(quotient);

        return quotient;
    }

    public static void simplifyMixedNumber(MixedNumber mixedNum) {

        if (mixedNum.getNumerator() >= mixedNum.getDenominator()) {
            int gcf = gcf(mixedNum.getNumerator(), mixedNum.getDenominator());
            mixedNum.setNumerator(mixedNum.getNumerator() / gcf);
            mixedNum.setDenominator(mixedNum.getDenominator() / gcf);
            int counter = 0;
            for (int i = 0; mixedNum.getNumerator() >= mixedNum.getDenominator(); i++) {
                mixedNum.setNumerator(mixedNum.getNumerator() - mixedNum.getDenominator());
                counter++;
            }

            mixedNum.setWholeNumber(mixedNum.getWholeNumber() + counter);
        }

    }

    public int convertDecimalToFraction(String decimal) {
        int counter = 0;

        double dec = Double.parseDouble(decimal);
        int whole = (int) dec;

        dec -= whole;

        String strDecimal = String.valueOf(dec);
        String den = "";

        for (int i = 0; i < strDecimal.length() - 2; ++i) {
            den += "0";
        }
        den = "1" + den;

        int denominator = Integer.parseInt(den);
        int numerator = Integer.parseInt(strDecimal.replace(".", ""));

        int gcf = gcd(numerator, denominator);

        setDenominator(denominator / gcf);
        setNumerator(numerator / gcf);

        for(int i = 0; numerator >= denominator; i++) {
            numerator -= denominator;
            counter++;
        }
        return counter;
    }

    public int getWholeNumber() {
        return wholeNumber;
    }

    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    }
}
