package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report implementation for student data.
 */
public class StudentReport extends Report {

    private String studentName;
    private double gpa;

    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    @Override
    protected String formatHeader() {
        return "Student Report";
    }

    @Override
    protected String formatBody() {
        return "Student Name: " + studentName + "\nGPA: " + gpa;
    }

    @Override
    protected String formatFooter() {
        return "End of Student Report";
    }
}