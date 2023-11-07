package com.project.studentregistrationsystem;

import com.itextpdf.text.DocumentException;
import com.project.studentregistrationsystem.filters.*;
import com.project.studentregistrationsystem.saveload.PDFAttendanceSaver;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AttendanceTabController implements Initializable {
    @FXML private TableView<Student> studentAttendance;
    @FXML private ChoiceBox<Month> month;
    @FXML private ChoiceBox<Specialty> specialtyChoiceBox;
    @FXML private Spinner<Integer> courseSpinner;
    @FXML private Spinner<Integer> groupSpinner;

    private ArrayList<Student> currentGroupStudents = new ArrayList<>();

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
        studentAttendance.getColumns().clear();
        studentAttendance.getItems().clear();

        TableColumn<Student, String> studentName = new TableColumn<>("Student");
        studentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentAttendance.getColumns().add(studentName);

        ArrayList<Student> students = StudentsDB.getStudentsCopy();
        applyAllFilters(students);

        int days = Date.daysInMonths.get(month.getValue());

        for (int i = 0; i < days; ++i) {
            TableColumn<Student, String> tableColumn = createStudentDayAttendanceColumn(i);
            studentAttendance.getColumns().add(tableColumn);
        }

        studentAttendance.getItems().addAll(students);
        currentGroupStudents = students;
    }

    private TableColumn<Student, String> createStudentDayAttendanceColumn(int i) {
        final int day = i;
        TableColumn<Student, String> tableColumn = new TableColumn<>(Integer.toString(day + 1));

        tableColumn.setCellValueFactory(studentStringCellDataFeatures -> {
            boolean value = studentStringCellDataFeatures.getValue().getAttendance(month.getValue()).get(day);

            return new SimpleStringProperty(value ? "+" : "");
        });

        tableColumn.setPrefWidth(30);
        return tableColumn;
    }

    private void applyAllFilters(ArrayList<Student> studentsCopy) {
        SpecialtyFilter specialtyFilter = new SpecialtyFilter(specialtyChoiceBox.getValue());
        GroupFilter groupFilter = new GroupFilter(groupSpinner.getValue());
        CourseFilter courseFilter = new CourseFilter(courseSpinner.getValue());

        specialtyFilter.apply(studentsCopy);
        groupFilter.apply(studentsCopy);
        courseFilter.apply(studentsCopy);
    }

    public void saveToPDF() throws DocumentException, FileNotFoundException {
        Specialty specialty = specialtyChoiceBox.getValue();
        int course = courseSpinner.getValue();
        int group = groupSpinner.getValue();

        GroupInfo groupInfo = new GroupInfo(specialty, course, group, currentGroupStudents);
        String fileName = specialty.toString() + '_' + course + "course_" + group + "group_" + month.getValue().toString();

        PDFAttendanceSaver attendanceSaver = new PDFAttendanceSaver("D:\\Projects\\Java\\Student-registration-system\\saves\\", month.getValue(), groupInfo);
        attendanceSaver.save(fileName);
    }
}