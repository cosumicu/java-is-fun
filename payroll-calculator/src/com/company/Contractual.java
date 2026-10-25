package com.company;

public class Contractual extends Employee{

    public Contractual(String fName, String mName, String lName){
        setfName(fName);
        setmName(mName);
        setlName(lName);
    }

    public float computeSalary(int days, int hours) {
        setSalary(days * getDailyRate());
        return getSalary();
    }

    public float computeDeduction() {
        setMonthlySalary(getDailyRate() * 20);
        setNetPay(getMonthlySalary() - 1250); // deduction is constant
        return getNetPay();
    }
}
