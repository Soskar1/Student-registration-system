package com.project.studentregistrationsystem.filters;

import com.project.studentregistrationsystem.students.Student;

import java.util.ArrayList;

public class GroupFilter implements StudentFilter {
    private final int group;

    public GroupFilter(int group) {
        this.group = group;
    }

    @Override
    public void apply(ArrayList<Student> students) {
        students.removeIf(student -> student.getGroup() != group);
    }
}
