package com.project.studentregistrationsystem.filters;

import com.project.studentregistrationsystem.students.Student;

import java.util.ArrayList;

public class CourseFilter implements StudentFilter {
    private final int course;

    public CourseFilter(int course) {
        this.course = course;
    }

    @Override
    public void apply(ArrayList<Student> students) {
        students.removeIf(student -> student.getCourse() != course);
    }
}
