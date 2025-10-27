package org.example;

public class PermanentEmp extends Employee {
    private double basicPay;
    private double hra;
    private int experience;
    private double varCom=0;

    PermanentEmp(int empId, String name, double basicPay, double hra, int experience){
        this.empId = empId;
        this.name=name;
        this.basicPay=basicPay;
        this.hra=hra;
        this.experience = experience;
    }

    void calculateSalary(){
        calVar();
        this.salary = this.varCom + this.basicPay + this.hra;
    }

    private void calVar(){
        if(this.experience<3)this.varCom=0;
        else if(this.experience<5) this.varCom=basicPay*0.05;
        else if(this.experience<10)this.varCom=basicPay*0.07;
        else this.varCom=basicPay*0.12;

    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getHra() {
        return hra;
    }

    public int getExperience() {
        return experience;
    }
}
