package com.project.studentregistrationsystem.filters;

import com.project.studentregistrationsystem.Specialty;
import com.project.studentregistrationsystem.Student;

import java.util.ArrayList;

public class SpecialtyFilter implements StudentFilter {
    private final Specialty specialty;

    public SpecialtyFilter(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public void apply(ArrayList<Student> students) {
        students.removeIf(student -> student.getSpecialty() != specialty);
    }
}
