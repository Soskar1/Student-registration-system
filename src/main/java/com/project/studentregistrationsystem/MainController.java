package com.project.studentregistrationsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML private Tab attendanceTab;
    @FXML private AttendanceTabController attendanceController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        attendanceTab.selectedProperty().addListener(event -> attendanceController.displayStudents());
    }
}
