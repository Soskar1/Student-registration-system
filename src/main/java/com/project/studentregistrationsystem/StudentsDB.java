package com.project.studentregistrationsystem;

import java.util.ArrayList;

public class StudentsDB {
    private final static ArrayList<Student> students = new ArrayList<>();
    public final static Observer onDataBaseUpdate = new Observer();

    public static void add(Student student) {
        students.add(student);

        onDataBaseUpdate.notifyListeners();
    }

    public static void remove(Student student) {
        students.remove(student);

        onDataBaseUpdate.notifyListeners();
    }

    public static ArrayList<Student> getStudentsCopy() {
        return new ArrayList<>(students);
    }
}
