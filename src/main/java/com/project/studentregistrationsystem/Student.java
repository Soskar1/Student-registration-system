package com.project.studentregistrationsystem;

import java.util.ArrayList;
import java.util.Collections;

public class Student {
    private final String name;
    private final int course;
    private final Specialty specialty;
    private final int group;
    private final ArrayList<ArrayList<Boolean>> attendance;

    public Student(String name, int course, Specialty specialty, int group) {
        this.name = name;
        this.course = course;
        this.specialty = specialty;
        this.group = group;

        attendance = new ArrayList<>() {{
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.January), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.February), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.March), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.April), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.May), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.June), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.July), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.August), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.September), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.October), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.November), false)));
            add(new ArrayList<>(Collections.nCopies(Date.daysInMonths.get(Month.December), false)));
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
