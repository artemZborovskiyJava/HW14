package com.javahw;

import java.util.Arrays;

public class Student {
    private String name;
    private String surname;
    private String dataOfBirth;
    private String contacts;
    private String[] groups;

    public Student(String name, String surname, String dataOfBirth, String contacts) {
        this.name = name;
        this.surname = surname;
        this.dataOfBirth = dataOfBirth;
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void addToGroup(String groupName) {
        String[] tmp;
        if(this.groups != null) {
            tmp = new String[this.groups.length + 1];
            System.arraycopy(this.groups, 0, tmp, 0, this.groups.length);
            tmp[groups.length] = groupName;
        } else {
            tmp = new String[1];
            tmp[0] = groupName;
        }
        this.groups = tmp;
    }

    public void printGroups() {
        System.out.println(Arrays.toString(this.groups));
    }
}