package com.project.studentregistrationsystem;

import com.project.studentregistrationsystem.students.Specialty;
import com.project.studentregistrationsystem.students.Student;

import java.util.ArrayList;

public class GroupInfo {
    private final Specialty specialty;
    private final int course;
    private final int group;
    private final ArrayList<Student> students;

    public GroupInfo(Specialty specialty, int course, int group, ArrayList<Student> students) {
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.students = students;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public int getCourse() {
        return course;
    }

    public int getGroup() {
        return group;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}