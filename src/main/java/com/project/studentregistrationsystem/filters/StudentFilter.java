package com.project.studentregistrationsystem.filters;

import com.project.studentregistrationsystem.Student;

import java.util.ArrayList;

public interface StudentFilter {
    ArrayList<Student> apply(ArrayList<Student> students);
}
