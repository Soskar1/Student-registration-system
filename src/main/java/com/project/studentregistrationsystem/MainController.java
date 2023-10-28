package com.project.studentregistrationsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML private TableView<Student> studentTableView;
    @FXML private TableColumn<Student, Integer> studentID;
    @FXML private TableColumn<Student, String> studentName;
    @FXML private TableColumn<Student, Integer> studentAge;
    @FXML private TableColumn<Student, String> studentSpecialty;
    @FXML private TableColumn<Student, Integer> studentCourse;
    @FXML private TableColumn<Student, Integer> studentGroup;

    @FXML private ChoiceBox<Specialty> specialtyFilter;
    @FXML private Spinner<Integer> courseFilter;
    @FXML private Spinner<Integer> groupFilter;

    private Student selectedStudent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentID.setCellValueFactory(new PropertyValueFactory<>("id"));
        studentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        studentSpecialty.setCellValueFactory(new PropertyValueFactory<>("specialty"));
        studentCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        studentGroup.setCellValueFactory(new PropertyValueFactory<>("group"));

        specialtyFilter.getItems().add(Specialty.COMPUTER_SCIENCE);
        specialtyFilter.getItems().add(Specialty.BIOINFORMATICS);

        SpinnerValueFactory<Integer> courseFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4);
        courseFilter.setValueFactory(courseFactory);

        SpinnerValueFactory<Integer> groupFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4);
        groupFilter.setValueFactory(groupFactory);
        groupFilter.setDisable(true);

        EventListener updateTableView = () -> studentTableView.getItems().setAll(StudentsDB.students);
        StudentsDB.onDataBaseUpdate.subscribe(updateTableView);
    }

    public void addStudent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StudentRegistrationSystem.class.getResource("student_registration.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Student Registration");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public void selectStudent() {
        selectedStudent = studentTableView.getSelectionModel().getSelectedItem();
    }

    public void removeStudent() {
        if (selectedStudent != null) {
            StudentsDB.remove(selectedStudent);
            selectedStudent = null;
        }
    }
}