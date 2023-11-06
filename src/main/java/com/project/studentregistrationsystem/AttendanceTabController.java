package com.project.studentregistrationsystem;

import com.project.studentregistrationsystem.filters.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AttendanceTabController implements Initializable {
    @FXML private TableView<Student> studentAttendance;
    @FXML private ChoiceBox<Month> month;
    @FXML private ChoiceBox<Specialty> specialtyChoiceBox;
    @FXML private Spinner<Integer> courseSpinner;
    @FXML private Spinner<Integer> groupSpinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        month.getItems().addAll(Month.values());
        month.setValue(Month.January);
        month.setOnAction(actionEvent -> displayStudents());

        specialtyChoiceBox.getItems().addAll(Specialty.values());
        specialtyChoiceBox.setValue(Specialty.COMPUTER_SCIENCE);
        specialtyChoiceBox.setOnAction(actionEvent -> displayStudents());

        SpinnerValueFactory<Integer> courseFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4);
        courseFactory.setValue(1);
        courseSpinner.setValueFactory(courseFactory);
        courseSpinner.valueProperty().addListener(event -> displayStudents());

        SpinnerValueFactory<Integer> groupFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);
        groupFactory.setValue(1);
        groupSpinner.setValueFactory(groupFactory);
        groupSpinner.valueProperty().addListener(event -> displayStudents());
    }

    public void displayStudents() {
        ArrayList<Student> students = new ArrayList<>(StudentsDB.students);
        applyAllFilters(students);
    }

    private void applyAllFilters(ArrayList<Student> studentsCopy) {
        SpecialtyFilter specialtyFilter = new SpecialtyFilter(specialtyChoiceBox.getValue());
        GroupFilter groupFilter = new GroupFilter(groupSpinner.getValue());
        CourseFilter courseFilter = new CourseFilter(courseSpinner.getValue());

        specialtyFilter.apply(studentsCopy);
        groupFilter.apply(studentsCopy);
        courseFilter.apply(studentsCopy);
    }
}
