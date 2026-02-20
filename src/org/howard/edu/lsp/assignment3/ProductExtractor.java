package org.howard.edu.lsp.assignment3;
    /**
 * Name: Nicholas Abram
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ProductExtractor reads product data from a file,
 * builds Product objects, and tracks valid and invalid records.
 *
 * Expected file format:
 * ProductID,Name,Price,Category
 */
public class ProductExtractor {

    /** List of valid Product objects */
    private List<Product> validProducts;

    /** Total number of lines processed (excluding header) */
    private int totalLines;

    /** Number of invalid product records */
    private int invalidCount;

    /**
     * Reads the file, skips the header, and attempts to
     * construct Product objects from each line.
     *
     * If construction fails, an empty Product is created
     * and marked as invalid.
     *
     * @param filename the name of the file to read
     */
    public void store(String filename) {
        validProducts = new ArrayList<>();
        totalLines = 0;
        invalidCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.readLine(); // Skip header line

            String line;
            while ((line = reader.readLine()) != null) {
                totalLines++;

                try {
                    String[] parts = line.split(",");

                    if (parts.length != 4) {
                        invalidCount++;
                        continue;
                    }

                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    String category = parts[3].trim();

                    Product product = new Product(productId, name, price, category);
                    product.setValid(true);
                    validProducts.add(product);

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    invalidCount++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Returns the list of valid products.
     *
     * @return List of valid Product objects
     */
    public List<Product> getValidProducts() {
        return validProducts;
    }

    /**
     * Returns total number of lines processed.
     *
     * @return totalLines
     */
    public int getTotalLines() {
        return totalLines;
    }

    /**
     * Returns number of invalid product records.
     *
     * @return invalidCount
     */
    public int getInvalidCount() {
        return invalidCount;
    }
}