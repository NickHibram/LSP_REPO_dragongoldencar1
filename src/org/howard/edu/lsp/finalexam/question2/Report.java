package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class that defines the Template Method pattern for generating reports.
 */
public abstract class Report {

    /**
     * Template method that defines the fixed workflow.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        System.out.println(formatHeader());
        System.out.println();
        System.out.println("=== BODY ===");
        System.out.println(formatBody());
        System.out.println();
        System.out.println("=== FOOTER ===");
        System.out.println(formatFooter());
        System.out.println();
    }

    protected abstract void loadData();
    protected abstract String formatHeader();
    protected abstract String formatBody();
    protected abstract String formatFooter();
}