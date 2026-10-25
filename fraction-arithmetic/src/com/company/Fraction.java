package com.company;

    public class Fraction {

    private int num;
    private int denom;

    //Constructor
    public Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    //Default constructor
    public Fraction() {
        this.num = 1;
        this.denom = 1;
    }

    //Simplify fraction
    public static void simplify(Fraction frac) {
        int gcd = 1;

        for(int i = 1; i <= frac.num && i <= frac.denom; ++i) {
            if(frac.num % i ==  0 && frac.denom % i == 0)
                gcd = i;

        }
        frac.num /= gcd;
        frac.denom /= gcd;
    }

    //Find lcm (instance)
    private int lcm(int denom) {

        int lcm = (this.denom > denom) ? this.denom : denom;

        while(true) {
            if( lcm % this.denom == 0 && lcm % denom == 0 ) {
                break;
            }
            ++lcm;
        }
        return lcm;
    }

    //find lcm (class)
    private static int lcm(int denom1, int denom2) {

        int lcm = (denom1 > denom2) ? denom1 : denom2;

        while(true) {
            if( lcm % denom1 == 0 && lcm % denom2 == 0 ) {
                break;
            }
            ++lcm;
        }
        return lcm;
    }

    public Fraction add(Fraction frac) {
        int sumNum, sumDenom;
        sumDenom = lcm(frac.denom);
        sumNum = sumDenom/this.denom*this.num + sumDenom/frac.denom*frac.num;

        Fraction sum = new Fraction(sumNum, sumDenom);
        simplify(sum);
        return sum;
    }

    public static Fraction add(Fraction frac1, Fraction frac2) {

        int sumDenom = lcm(frac1.denom, frac2.denom);
        int sumNum = sumDenom/frac1.denom*frac1.num + sumDenom/frac2.denom*frac2.num;

        Fraction sum = new Fraction(sumNum, sumDenom);
        simplify(sum);
        return sum;
    }

    public Fraction subtract(Fraction frac) {
        int sumNum, sumDenom;
        sumDenom = lcm(frac.denom);
        sumNum = sumDenom/this.denom*this.num - sumDenom/frac.denom*frac.num;

        Fraction difference = new Fraction(sumNum, sumDenom);
        simplify(difference);
        return difference;
    }

    public static Fraction subtract(Fraction frac1, Fraction frac2) {

        int sumDenom = lcm(frac1.denom, frac2.denom);
        int sumNum = sumDenom/frac1.denom*frac1.num - sumDenom/frac2.denom*frac2.num;

        Fraction sum = new Fraction(sumNum, sumDenom);
        simplify(sum);
        return sum;
    }


    public Fraction multiply(Fraction frac) {

        int productNum = this.num * frac.num;
        int productDenom = this.denom * frac.denom;

        Fraction product = new Fraction(productNum, productDenom);
        simplify(product);

        return product;
    }

    public static Fraction multiply(Fraction frac1, Fraction frac2) {

        int productNum = frac1.num * frac2.num;
        int productDenom = frac1.denom * frac2.denom;

        Fraction product = new Fraction(productNum, productDenom);
        simplify(product);

        return product;
    }

    public Fraction divide(Fraction frac) {

        int quotientNum = this.num * frac.denom;
        int quotientDenom = this.denom * frac.num;

        Fraction quotient = new Fraction(quotientNum, quotientDenom);
        simplify(quotient);
        return quotient;
    }

    public static Fraction divide(Fraction frac1, Fraction frac2) {
        int quotientNum = frac1.num * frac2.denom;
        int quotientDenom = frac1.denom * frac2.num;

        Fraction quotient = new Fraction(quotientNum, quotientDenom);
        simplify(quotient);
        return quotient;
    }

    public int compareTo(Fraction frac) {

        double n1 = this.num;
        double n2 = frac.num;
        double d1 = this.denom;
        double d2 = frac.denom;

        double a1 = n1/d1;
        double a2 = n2/d2;

        if (a1 > a2)
            return 1;
        else if(a1 == a2)
            return 0;
        else
            return -1;
    }

    public static boolean greaterThan(Fraction frac1, Fraction frac2) {

        double n1 = frac1.num;
        double n2 = frac2.num;
        double d1 = frac1.denom;
        double d2 = frac2.denom;

        double a1 = n1/d1;
        double a2 = n2/d2;

        if(a1 > a2)
            return true;
        return false;
    }

    public static boolean lessThan(Fraction frac1, Fraction frac2) {

        double n1 = frac1.num;
        double n2 = frac2.num;
        double d1 = frac1.denom;
        double d2 = frac2.denom;

        double a1 = n1/d1;
        double a2 = n2/d2;

        if(a1 < a2)
            return true;
        return false;
    }

    public static boolean equals(Fraction frac1, Fraction frac2) {

        double n1 = frac1.num;
        double n2 = frac2.num;
        double d1 = frac1.denom;
        double d2 = frac2.denom;

        double a1 = n1/d1;
        double a2 = n2/d2;

        if(a1 == a2)
            return true;
        return false;
    }

    //Situational toString (class)
    public static String toString(Fraction frac) {
        return frac.num + "/" + frac.denom;
    }

    public String toString() {
        return this.num + "/" + this.denom;
    }

    //Getters, Setters
        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getDenom() {
            return denom;
        }

        public void setDenom(int denom) {
            this.denom = denom;
        }
    }











