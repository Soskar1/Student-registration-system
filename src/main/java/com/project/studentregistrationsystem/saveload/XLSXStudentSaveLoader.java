package com.project.studentregistrationsystem.saveload;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.project.studentregistrationsystem.Student;
import com.project.studentregistrationsystem.StudentsDB;
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

        String path = getSaveDirectory() + fileName + ".xlsx";
        FileOutputStream out = new FileOutputStream(path);

        workbook.write(out);
        out.close();
    }

    @Override
    public ArrayList<Student> load(String fileName) throws FileNotFoundException {
        return null;
    }
}
