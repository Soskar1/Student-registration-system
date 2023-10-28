package com.project.studentregistrationsystem;

public class Student {
    private String name;
    private int age;
    private int course;
    private Specialty specialty;
    private int group;
    private int id;

    public Student(String name, int age, int course, Specialty specialty, int group) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.specialty = specialty;
        this.group = group;
        id = -1;
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
}
