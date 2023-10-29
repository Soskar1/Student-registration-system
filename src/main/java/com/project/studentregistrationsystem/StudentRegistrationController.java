package com.project.studentregistrationsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentRegistrationController implements Initializable {
    @FXML private TextField name;
    @FXML private Spinner<Integer> age;
    @FXML private Spinner<Integer> course;
    @FXML private Spinner<Integer> group;
    @FXML private ChoiceBox<Specialty> specialty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        specialty.getItems().add(Specialty.COMPUTER_SCIENCE);
        specialty.getItems().add(Specialty.BIOINFORMATICS);

        SpinnerValueFactory<Integer> ageFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(18, Integer.MAX_VALUE);
        age.setValueFactory(ageFactory);

        SpinnerValueFactory<Integer> courseFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4);
        course.setValueFactory(courseFactory);

        SpinnerValueFactory<Integer> groupFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);
        group.setValueFactory(groupFactory);
    }

    public void OnAddButtonPressed() {
        Student student = new Student(name.getText(), age.getValue(), course.getValue(), specialty.getValue(), group.getValue());
        StudentsDB.add(student);
    }
}
