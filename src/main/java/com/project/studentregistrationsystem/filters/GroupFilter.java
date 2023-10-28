package com.project.studentregistrationsystem.filters;

import com.project.studentregistrationsystem.Student;

import java.util.ArrayList;

public class GroupFilter extends StudentDecorator {
    private final int group;

    public GroupFilter(StudentFilter filter, int group) {
        super(filter);
        this.group = group;
    }

    @Override
    public ArrayList<Student> apply(ArrayList<Student> students) {
        students.removeIf(student -> student.getGroup() != group);
        return students;
    }
}
