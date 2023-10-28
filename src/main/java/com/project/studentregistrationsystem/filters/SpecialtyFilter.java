package com.project.studentregistrationsystem.filters;

import com.project.studentregistrationsystem.Specialty;
import com.project.studentregistrationsystem.Student;

import java.util.ArrayList;

public class SpecialtyFilter extends StudentDecorator {
    private final Specialty specialty;

    public SpecialtyFilter(StudentFilter filter, Specialty specialty) {
        super(filter);
        this.specialty = specialty;
    }

    @Override
    public ArrayList<Student> apply(ArrayList<Student> students) {
        students.removeIf(student -> student.getSpecialty() != specialty);
        return students;
    }
}
