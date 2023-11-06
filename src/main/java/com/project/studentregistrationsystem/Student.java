package com.project.studentregistrationsystem;

import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.Collections;

public class Student {
    private String name;
    private int course;
    private Specialty specialty;
    private int group;
    private final ArrayList<ArrayList<Boolean>> attendance;

    public Student(String name, int course, Specialty specialty, int group) {
        this.name = name;
        this.course = course;
        this.specialty = specialty;
        this.group = group;

        attendance = new ArrayList<>() {{
            add(new ArrayList<>(Collections.nCopies(31, false)));   //January
            add(new ArrayList<>(Collections.nCopies(28, false)));   //February
            add(new ArrayList<>(Collections.nCopies(31, false)));   //March
            add(new ArrayList<>(Collections.nCopies(30, false)));   //April
            add(new ArrayList<>(Collections.nCopies(31, false)));   //May
            add(new ArrayList<>(Collections.nCopies(30, false)));   //June
            add(new ArrayList<>(Collections.nCopies(31, false)));   //July
            add(new ArrayList<>(Collections.nCopies(31, false)));   //August
            add(new ArrayList<>(Collections.nCopies(30, false)));   //September
            add(new ArrayList<>(Collections.nCopies(31, false)));   //October
            add(new ArrayList<>(Collections.nCopies(30, false)));   //November
            add(new ArrayList<>(Collections.nCopies(31, false)));   //December
        }};
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public int getGroup() {
        return group;
    }

    public ArrayList<Boolean> getAttendance(Month month) {
        return attendance.get(month.ordinal());
    }

    public void setAttendance(Month month, int day, boolean value) {
        var days = attendance.get(month.ordinal());
        --day;

        if (day >= days.size()) {
            return;
        }

        days.set(day, value);
    }
}
