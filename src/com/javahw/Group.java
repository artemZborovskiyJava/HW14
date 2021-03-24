package com.javahw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Group {
    private String courseName;
    private String startDateOfClasses;
    private int totalNumberOfLessons;
    private int numberOfLessonsPerWeek;
    private Student[] arrayOfStudents;
    private Teacher teacher;

    public Group(String courseName, String startDateOfClasses, int totalNumberOfLessons, int numberOfLessonsPerWeek, Student[] listOfStudents, Teacher teacher) {
        this.courseName = courseName;
        this.startDateOfClasses = startDateOfClasses;
        this.totalNumberOfLessons = totalNumberOfLessons;
        this.numberOfLessonsPerWeek = numberOfLessonsPerWeek;
        this.arrayOfStudents = listOfStudents;
        this.teacher = teacher;
    }

    public String groupName() {
        return this.courseName + " " + this.startDateOfClasses;
    }

    public void lastLessonDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDateOfClassesDate = LocalDate.parse(this.startDateOfClasses, formatter);
        int durationOfCourse = totalNumberOfLessons / numberOfLessonsPerWeek * 7;
        System.out.println(startDateOfClassesDate.plusDays(durationOfCourse).format(formatter));
    }

    public void printStudents() {
        for(int i = 0; i < this.arrayOfStudents.length; i++) {
            char firstLetterOfName = this.arrayOfStudents[i].getName().charAt(0);
            System.out.println(i + 1 + ") " + firstLetterOfName + ". " + this.arrayOfStudents[i].getSurname());
        }
    }

    public void addStudent(Student student) {
        Student[] tmp = new Student[this.arrayOfStudents.length + 1];
        System.arraycopy(this.arrayOfStudents, 0, tmp, 0, this.arrayOfStudents.length);
        tmp[arrayOfStudents.length] = student;
        this.arrayOfStudents = tmp;
        student.addToGroup(this.groupName());
    }

    public void isStudentInGroup(String surname) {
        for(Student student : this.arrayOfStudents) {
            if(student.getSurname().equals(surname)) {
                System.out.println("Студент " + surname + " есть в группе");
                return;
            }
        }
        System.out.println("Студента с фамилией " + surname + " нет в группе");
    }

    public void deleteStudentBySurname(String surname) {
        for(Student student : this.arrayOfStudents) {
            if(student.getSurname().equals(surname)) {
                ArrayList<Student> listOfStudents = new ArrayList<Student>(Arrays.asList(this.arrayOfStudents));
                listOfStudents.remove(Arrays.asList(this.arrayOfStudents).indexOf(student));
                this.arrayOfStudents = listOfStudents.toArray(new Student[0]);
                return;
            }
        }
        System.out.println("Студента с фамилией " + surname + " нет в группе");
    }

    public void deleteStudentByNumber(int number) {
        if(number < this.arrayOfStudents.length + 1) {
            ArrayList<Student> listOfStudents = new ArrayList<Student>(Arrays.asList(this.arrayOfStudents));
            listOfStudents.remove(number - 1);
            this.arrayOfStudents = listOfStudents.toArray(new Student[0]);
            return;
        }
        System.out.println("Студента с номером " + number + " нет в группе");
    }
}