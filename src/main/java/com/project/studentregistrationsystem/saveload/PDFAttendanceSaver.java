package com.project.studentregistrationsystem.saveload;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import com.project.studentregistrationsystem.Date;
import com.project.studentregistrationsystem.GroupInfo;
import com.project.studentregistrationsystem.Month;
import com.project.studentregistrationsystem.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PDFAttendanceSaver extends DataSaveLoader {
    private final Month month;
    private final GroupInfo groupInfo;

    public PDFAttendanceSaver(String saveDirectory, Month month, GroupInfo groupInfo) {
        super(saveDirectory);

        this.month = month;
        this.groupInfo = groupInfo;
    }

    @Override
    public void save(String fileName) throws FileNotFoundException, DocumentException {
        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(getSaveDirectory() + fileName + ".pdf"));

        document.open();

        document.setPageSize(PageSize.A3.rotate());
        document.newPage();

        document.add(new Paragraph(groupInfo.getSpecialty().toString() + ", " +
                groupInfo.getCourse() + " course, " +
                groupInfo.getGroup() + " group"));

        document.add(new Paragraph(month.toString()));

        int numberOfColumns = 1 + Date.daysInMonths.get(month);
        PdfPTable table = new PdfPTable(numberOfColumns);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        float[] columnWidths = new float[numberOfColumns];
        Arrays.fill(columnWidths, 1f);
        columnWidths[0] = 2.5f;
        table.setWidths(columnWidths);

        PdfPCell name = new PdfPCell(new Paragraph("Name"));
        table.addCell(name);

        for (int i = 1; i < numberOfColumns; ++i) {
            PdfPCell cell = new PdfPCell(new Paragraph(Integer.toString(i)));
            table.addCell(cell);
        }

        for (Student student : groupInfo.getStudents()) {
            saveStudent(table, student, month);
        }

        document.add(table);

        document.close();
        writer.close();
    }

    @Override
    public ArrayList<Student> load(String fileName) throws IOException {
        return null;
    }

    private void saveStudent(PdfPTable table, Student student, Month month) {
        table.addCell(student.getName());

        for (int i = 1; i < table.getNumberOfColumns(); ++i) {
            boolean value = student.getAttendance(month).get(i - 1);
            table.addCell(value ? "+" : " ");
        }
    }
}
