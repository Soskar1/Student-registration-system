package com.project.studentregistrationsystem.saveload;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.project.studentregistrationsystem.Specialty;
import com.project.studentregistrationsystem.Student;
import com.project.studentregistrationsystem.StudentsDB;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXStudentSaveLoader extends DataSaveLoader {
    public XLSXStudentSaveLoader(String saveDirectory) {
        super(saveDirectory);
    }

    @Override
    public void save(String fileName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Students");

        XSSFRow row = spreadsheet.createRow(0);
        row.createCell(0).setCellValue("Name");
        row.createCell(1).setCellValue("Specialty");
        row.createCell(2).setCellValue("Course");
        row.createCell(3).setCellValue("Group");

        ArrayList<Student> students = StudentsDB.getStudentsCopy();
        int rowID = 1;
        for (Student student : students) {
            row = spreadsheet.createRow(rowID);
            row.createCell(0).setCellValue(student.getName());
            row.createCell(1).setCellValue(student.getSpecialty().toString());
            row.createCell(2).setCellValue(student.getCourse());
            row.createCell(3).setCellValue(student.getGroup());

            ++rowID;
        }

        String path = getSaveDirectory() + fileName;
        FileOutputStream out = new FileOutputStream(path);

        workbook.write(out);
        out.close();
    }

    @Override
    public ArrayList<Student> load(String fileName) throws IOException {
        String path = getSaveDirectory() + fileName;
        InputStream stream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(stream);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);

        ArrayList<Student> students = new ArrayList<>();

        Iterator<Row> rowIterator = spreadsheet.rowIterator();
        rowIterator.next(); //skip naming row

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Student student = convertToStudent(row);

            students.add(student);
        }

        stream.close();
        return students;
    }

    private Student convertToStudent(Row row) {
        String name = row.getCell(0).getStringCellValue();
        Specialty specialty = Specialty.valueOf(row.getCell(1).getStringCellValue());
        int course = (int)row.getCell(2).getNumericCellValue();
        int group = (int)row.getCell(3).getNumericCellValue();

        return new Student(name, course, specialty, group);
    }
}
