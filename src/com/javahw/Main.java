package com.javahw;

public class Main {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("Olesia", "Sadovaya", "23.03.1995", "0764561234", 25000);
        Student george = new Student("George", "Nowell", "11.09.1998", "0971057212");
        Student ivan = new Student("Ivan", "Borisov", "21.11.1987", "0891057976");
	    Group group1 = new Group("Java", "28.01.2021", 5 , 2, new Student[]{}, teacher);
	    group1.addStudent(george);
	    group1.addStudent(ivan);
	    ivan.printGroups();
        Group group2 = new Group("Front-End", "28.01.2021", 5 , 2, new Student[]{}, teacher);
        group2.addStudent(ivan);
        ivan.printGroups();
        group1.isStudentInGroup("Abramov");
        group1.lastLessonDate();
        group1.deleteStudentBySurname("Borisov");
        group1.printStudents();
    }
}