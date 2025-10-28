package org.example;

import org.example.program.Student;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student(1,"ram",240);
        Student s2 = new Student(2, "sam", 300);
        Student s3 = new Student(3,"tom",100);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }
}