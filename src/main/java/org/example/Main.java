package org.example;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
//        FibSeries f = new FibSeries();
//        f.printSeries();

        Employee permanentEmp = new PermanentEmp(101,"anil",10000,1500,3);
        Employee contractEmp = new ContractEmp(102,"ankit",500,10);

        permanentEmp.calculateSalary();
        contractEmp.calculateSalary();

        System.out.println("permanentEmp : "+permanentEmp.getSalary());
        System.out.println("contractEmp : "+contractEmp.getSalary());
    }
}