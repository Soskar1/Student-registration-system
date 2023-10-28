package com.project.studentregistrationsystem;

import java.util.ArrayList;

public class StudentsDB {
    public final static ArrayList<Student> students = new ArrayList<>();
    public final static Observer onDataBaseUpdate = new Observer();

    public static void add(Student student) {
        student.setId(students.size());
        students.add(student);

        onDataBaseUpdate.notifyListeners();
    }
}
