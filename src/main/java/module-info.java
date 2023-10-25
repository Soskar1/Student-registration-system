module com.project.studentregistrationsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.studentregistrationsystem to javafx.fxml;
    exports com.project.studentregistrationsystem;
}