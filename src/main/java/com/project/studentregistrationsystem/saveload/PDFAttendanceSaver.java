package com.project.studentregistrationsystem.saveload;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.studentregistrationsystem.Date;
import com.project.studentregistrationsystem.GroupInfo;
import com.project.studentregistrationsystem.Month;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;

public class PDFAttendanceSaver {
    public void save(String fileName, Month month, GroupInfo groupInfo) throws FileNotFoundException, DocumentException {
        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
        document.open();
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
        table.setWidths(columnWidths);

        PdfPCell name = new PdfPCell(new Paragraph("Name"));
        table.addCell(name);

        for (int i = 1; i < numberOfColumns; ++i) {
            PdfPCell cell = new PdfPCell(new Paragraph(Integer.toString(i)));
            table.addCell(cell);
        }

        document.add(table);

        document.close();
        writer.close();
    }
}
