package com.project.studentregistrationsystem;

import javafx.scene.control.CheckBox;

import java.util.ArrayList;

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
            add(new ArrayList<>(31));   //January
            add(new ArrayList<>(28));   //February
            add(new ArrayList<>(31));   //March
            add(new ArrayList<>(30));   //April
            add(new ArrayList<>(31));   //May
            add(new ArrayList<>(30));   //June
            add(new ArrayList<>(31));   //July
            add(new ArrayList<>(31));   //August
            add(new ArrayList<>(30));   //September
            add(new ArrayList<>(31));   //October
            add(new ArrayList<>(30));   //November
            add(new ArrayList<>(31));   //December
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
