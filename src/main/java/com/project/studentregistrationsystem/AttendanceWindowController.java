package com.project.studentregistrationsystem;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class AttendanceWindowController {
    @FXML private Label studentName;
    @FXML private Label studentSpecialty;
    @FXML private Label studentCourse;
    @FXML private Label studentGroup;

    @FXML private ChoiceBox<Month> monthChoiceBox;
    @FXML private Spinner<Integer> daySpinner;

    private Student student;

    public void initialize(Student student) {
        this.student = student;

        studentName.setText(student.getName());
        studentSpecialty.setText(student.getSpecialty().toString());
        studentCourse.setText("Course: " + student.getCourse());
        studentGroup.setText("Group: " + student.getGroup());

        monthChoiceBox.getItems().setAll(Month.values());
        monthChoiceBox.setValue(Month.January);

        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 31);
        daySpinner.setValueFactory(factory);
    }

    public void markAttendance() {
        student.setAttendance(monthChoiceBox.getValue(), daySpinner.getValue(), true);
    }

    public void eraseAttendance() {
        student.setAttendance(monthChoiceBox.getValue(), daySpinner.getValue(), false);
    }
}
