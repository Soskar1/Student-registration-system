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

    public static void remove(Student student) {
        int id = student.getId();
        students.remove(id);

        for (int i = id; i < students.size(); ++i) {
            students.get(i).setId(i);
        }

        onDataBaseUpdate.notifyListeners();
    }
}
