package org.example.program;

public enum Grades {

    A(5), B(4), C(3), D(2), F(0);

    private int value;

    Grades(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
