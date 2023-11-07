package com.project.studentregistrationsystem.saveload;

import com.project.studentregistrationsystem.Specialty;
import com.project.studentregistrationsystem.Student;
import com.project.studentregistrationsystem.StudentsDB;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;
import java.util.Scanner;

public class CSVStudentSaveLoader extends DataSaveLoader {
    private final String extension = ".csv";

    public CSVStudentSaveLoader(String saveDirectory) {
        super(saveDirectory);
    }

    @Override
    public void save(String fileName) throws IOException {
        String filePath = getSaveDirectory() + fileName + extension;
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

    @Override
    public ArrayList<Student> load(String fileName) throws FileNotFoundException {
        ArrayList<Student> students = new ArrayList<>();

        String filePath = getSaveDirectory() + fileName + extension;
        File file = new File(filePath);

        Scanner scanner = new Scanner(file);
        scanner.nextLine(); //skip naming row

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            Student student = convertToStudent(data);

            students.add(student);
        }

        return students;
    }

    private Student convertToStudent(String studentData) {
        String[] separatedStudentData = studentData.split(";");

        Specialty specialty = Specialty.valueOf(separatedStudentData[1]);
        int course = Integer.parseInt(separatedStudentData[2]);
        int group = Integer.parseInt(separatedStudentData[3]);

        return new Student(separatedStudentData[0], course, specialty, group);
    }
}
