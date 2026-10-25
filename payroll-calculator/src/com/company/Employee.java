package com.company;

abstract class Employee {

    private String fName, mName, lName;
    private float dailyRate, salary, monthlySalary, deduction;
    private float grossPay, netPay;

//    public Employee(String fName, String mName, String lName) {
//        this.fName = fName;
//        this.mName = mName;
//        this.lName = lName;
//    }

    abstract float computeSalary(int days, int hours);
    abstract  float computeDeduction();

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public float getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(float dailyRate) {
        this.dailyRate = dailyRate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public float getDeduction() {
        return deduction;
    }

    public void setDeduction(float deduction) {
        this.deduction = deduction;
    }

    public float getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(float grossPay) {
        this.grossPay = grossPay;
    }

    public float getNetPay() {
        return netPay;
    }

    public void setNetPay(float netPay) {
        this.netPay = netPay;
    }
}
