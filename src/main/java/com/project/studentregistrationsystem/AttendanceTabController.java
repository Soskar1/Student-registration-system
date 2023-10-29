package com.project.studentregistrationsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class AttendanceTabController implements Initializable {
    @FXML private TableView<Student> studentAttendance;
    @FXML private ChoiceBox<Month> month;
    @FXML private ChoiceBox<Specialty> specialtyFilter;
    @FXML private Spinner<Integer> courseFilter;
    @FXML private Spinner<Integer> groupFilter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        month.getItems().addAll(Month.values());
        specialtyFilter.getItems().addAll(Specialty.values());

        SpinnerValueFactory<Integer> courseFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4);
        courseFilter.setValueFactory(courseFactory);

        SpinnerValueFactory<Integer> groupFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);
        groupFilter.setValueFactory(groupFactory);
    }
}
