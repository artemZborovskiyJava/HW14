package com.javahw;

public class Teacher extends Student {
    private int salary;

    public Teacher(String name, String surname, String dataOfBirth, String contacts, int salary) {
        super(name, surname, dataOfBirth, contacts);
        this.salary = salary;
    }
}