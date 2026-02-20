package org.howard.edu.lsp.assignment3;
    /**
 * Name: Nicholas Abram
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * ProductLoader represents the "Load" stage of the ETL pipeline.
 * Writes transformed product records to an output CSV file and
 * tracks successful and failed uploads.
 */
public class ProductLoader {

    /** Number of product records that failed to upload/write */
    private int failedUploads;

    /** Number of product records successfully uploaded/written */
    private int successfulUploads;

    /**
     * Writes a list of transformed products to the output CSV file.
     * Writes the header row first, then each product as a CSV line.
     * Tracks successful and failed writes internally.
     *
     * @param products list of transformed products to write
     */
    public void upload(List<ProductTransformer> products) {
        failedUploads = 0;
        successfulUploads = 0;
        String outputPath = "data/transformed_products.csv";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath))) {
            bufferedWriter.write("ProductID,Name,Price,Category,PriceRange");
            bufferedWriter.newLine();

            for (ProductTransformer product : products) {
                try {
                    bufferedWriter.write(product.toCSVString());
                    bufferedWriter.newLine();
                    successfulUploads++;
                } catch (IOException e) {
                    failedUploads++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error Reading/Writing File: " + e.getMessage());
        }
    }

    /**
     * Prints a summary report of the ETL pipeline results.
     * Includes total lines read, skipped, transformed,
     * successful uploads, failed uploads, and output file path.
     *
     * @param totalLines total number of records read excluding header
     * @param invalidCount number of invalid or skipped records
     */
    public void printSummary(int totalLines, int invalidCount) {
        int transformedCount = totalLines - invalidCount;
        System.out.println(
            "Data Successfully Extracted\n\tSummary is as follows\n" +
            "Total lines read: " + totalLines + "\n" +
            "Total lines skipped: " + invalidCount + "\n" +
            "Total lines transformed: " + transformedCount + "\n" +
            "Successful uploads: " + successfulUploads + "\n" +
            "Failed uploads: " + failedUploads + "\n" +
            "Output File Path: data/transformed_products.csv"
        );
    }

    /**
     * Returns the number of failed uploads.
     *
     * @return failedUploads
     */
    public int getFailedUploads() {
        return failedUploads;
    }

    /**
     * Returns the number of successful uploads.
     *
     * @return successfulUploads
     */
    public int getSuccessfulUploads() {
        return successfulUploads;
    }
}