package com.company;

public class Regular extends Employee{

    private float basicPay, overtimePay;

    public Regular(String fName, String mName, String lName){
        setfName(fName);
        setmName(mName);
        setlName(lName);
    }

    public float computeSalary(int days, int hours) {
        setBasicPay(days * getDailyRate());
        setOvertimePay(hours * (getDailyRate() * 0.15f));
        setSalary(getBasicPay() + getOvertimePay());
        return getSalary();
    }

    public float computeDeduction() {
        setMonthlySalary(getDailyRate() * 20);
        setDeduction(getMonthlySalary() *  0.20f); // deduction (20% of monthly salary)
        setNetPay(getMonthlySalary() - (getMonthlySalary() *  0.20f));
        return getNetPay();
    }

    public static float showDeduction(Employee employee) {
        return (employee.getMonthlySalary() *  0.20f);
    }

    public float getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(float basicPay) {
        this.basicPay = basicPay;
    }

    public float getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(float overtimePay) {
        this.overtimePay = overtimePay;
    }

//    @Override
//    public float getDeduction() {
//        return getMonthlySalary() *  0.20f;
//    }
}
