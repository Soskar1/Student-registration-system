package com.project.studentregistrationsystem.saveload;

import com.itextpdf.text.DocumentException;
import com.project.studentregistrationsystem.Student;

import java.io.IOException;
import java.util.ArrayList;

public abstract class DataSaveLoader {
    private final String saveDirectory;

    public DataSaveLoader(String saveDirectory) {
        this.saveDirectory = saveDirectory;
    }

    public abstract void save(String fileName) throws IOException, DocumentException;
    public abstract ArrayList<Student> load(String fileName) throws IOException;

    protected String getSaveDirectory() {
        return saveDirectory;
    }
}