package org.example;

public class ContractEmp extends Employee{
    private double wages;
    private int hours;

    ContractEmp(int empId, String name, double wages, int hours){
        this.empId=empId;
        this.name=name;
        this.wages=wages;
        this.hours=hours;
    }

    void calculateSalary(){
        this.salary=this.hours*this.wages;
    }

    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
