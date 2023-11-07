package com.project.studentregistrationsystem.saveload;

import java.io.IOException;

public abstract class DataSaver {
    private final String saveDirectory;

    public DataSaver(String saveDirectory) {
        this.saveDirectory = saveDirectory;
    }

    public abstract void save(String fileName) throws IOException;

    protected String getSaveDirectory() {
        return saveDirectory;
    }
}