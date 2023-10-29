package com.project.studentregistrationsystem;

import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class Student {
    private String name;
    private int age;
    private int course;
    private Specialty specialty;
    private int group;
    private int id;
    private final ArrayList<ArrayList<CheckBox>> attendance;

    public Student(String name, int age, int course, Specialty specialty, int group) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.specialty = specialty;
        this.group = group;
        id = -1;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<CheckBox> getAttendanceList(Month month) {
        return attendance.get(month.ordinal());
    }
}
