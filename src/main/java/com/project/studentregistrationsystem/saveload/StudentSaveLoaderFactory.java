package com.project.studentregistrationsystem.saveload;

public class StudentSaveLoaderFactory {
    private static String saveDirectory = "D:\\Projects\\Java\\Student-registration-system\\saves\\";

    public static DataSaveLoader getSaveLoader(String fileName) {
        if (fileName.contains(".xlsx")) {
            return new XLSXStudentSaveLoader(saveDirectory);
        }

        if (fileName.contains(".csv")) {
            return new CSVStudentSaveLoader(saveDirectory);
        }

        return null;
    }
}
