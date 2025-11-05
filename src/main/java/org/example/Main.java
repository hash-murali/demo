package org.example;

import org.example.program.CreditCardPayment;
import org.example.program.ShoppingPayment;
import org.example.program.Student;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

//        Student s1 = new Student(1,"ram",240);
//        Student s2 = new Student(2, "sam", 300);
//        Student s3 = new Student(3,"tom",100);
//
//        System.out.println(s1.toString());
//        System.out.println(s2.toString());
//        System.out.println(s3.toString());

        ShoppingPayment s1=new ShoppingPayment(1000),s2=new ShoppingPayment(200);
        CreditCardPayment c1=new CreditCardPayment(1000,500),c2=new CreditCardPayment(200,300);
        s1.payBill(200);
        s2.payBill(1000);
        c1.payBill(600);
        System.out.println(c1.toString());
        c2.payBill(0);
        System.out.println(c2.toString());


    }
}