package com.project.studentregistrationsystem.filters;

import com.project.studentregistrationsystem.Student;

import java.util.ArrayList;

public class CourseFilter extends StudentDecorator {
    private final int course;

    public CourseFilter(StudentFilter filter, int course) {
        super(filter);
        this.course = course;
    }

    @Override
    public ArrayList<Student> apply(ArrayList<Student> students) {
        students.removeIf(student -> student.getCourse() != course);
        return students;
    }
}
