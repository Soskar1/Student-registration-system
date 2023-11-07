module com.project.studentregistrationsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;


    opens com.project.studentregistrationsystem to javafx.fxml;
    exports com.project.studentregistrationsystem;
    exports com.project.studentregistrationsystem.filters;
    opens com.project.studentregistrationsystem.filters to javafx.fxml;
}