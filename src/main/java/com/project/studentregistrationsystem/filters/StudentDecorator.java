package com.project.studentregistrationsystem.filters;

import com.project.studentregistrationsystem.Student;

import java.util.ArrayList;

public class StudentDecorator implements StudentFilter {
    protected StudentFilter filter;

    public StudentDecorator(StudentFilter filter) {
        this.filter = filter;
    }

    @Override
    public ArrayList<Student> apply(ArrayList<Student> students) {
        return filter.apply(students);
    }
}
