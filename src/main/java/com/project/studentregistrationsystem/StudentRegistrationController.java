package com.project.studentregistrationsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentRegistrationController {
    @FXML private TextField name;
    @FXML private Spinner<Integer> course;
    @FXML private Spinner<Integer> group;
    @FXML private ChoiceBox<Specialty> specialty;

    public void initialize(Student student) {
        specialty.getItems().add(Specialty.COMPUTER_SCIENCE);
        specialty.getItems().add(Specialty.BIOINFORMATICS);
        specialty.setValue(student == null ? Specialty.COMPUTER_SCIENCE : student.getSpecialty());

        name.setText(student == null ? "" : student.getName());

        SpinnerValueFactory<Integer> courseFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4);
        courseFactory.setValue(student == null ? 1 : student.getCourse());
        course.setValueFactory(courseFactory);

        SpinnerValueFactory<Integer> groupFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);
        groupFactory.setValue(student == null ? 1 : student.getGroup());
        group.setValueFactory(groupFactory);
    }

    public void OnAddButtonPressed() {
        Student student = new Student(name.getText(), course.getValue(), specialty.getValue(), group.getValue());
        StudentsDB.add(student);
    }
}
