package com.project.studentregistrationsystem.saveload;

import com.project.studentregistrationsystem.Student;
import com.project.studentregistrationsystem.StudentsDB;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;

public class CSVDataSaver extends DataSaver {
    public CSVDataSaver(String saveDirectory) {
        super(saveDirectory);
    }

    @Override
    public void save(String fileName) throws IOException {
        String filePath = getSaveDirectory() + fileName + ".csv";
        File file = new File(filePath);

        if (file.createNewFile()) {
            System.out.println("file created");
        } else {
            System.out.println("file already exists");
        }

        ArrayList<Student> students = StudentsDB.getStudentsCopy();

        FileWriter writer = new FileWriter(filePath);
        writer.write("Name;Specialty;Course;Group\n");

        for (Student student : students) {
            writer.write(student.getName() + ';' +
                    student.getSpecialty().toString() + ';' +
                    student.getCourse() + ';' +
                    student.getGroup() + '\n');
        }

        writer.close();
    }
}
