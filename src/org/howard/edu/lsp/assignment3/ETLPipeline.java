package org.howard.edu.lsp.assignment3;
    /**
 * Name: Nicholas Abram
 */
import java.util.ArrayList;
import java.util.List;
/**
 * ETLPipeline is the main driver class that orchestrates
 * the Extract, Transform, and Load stages.
 *
 * Flow:
 * 1. Extract products from input file
 * 2. Transform valid products
 * 3. Load transformed products into output file
 * 4. Print summary report
 */
public class ETLPipeline {
    /**
     * Main method that executes the ETL pipeline.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // ======== EXTRACT ========
        ProductExtractor extractor = new ProductExtractor();
        extractor.store("data/products.csv");
        // Get valid extracted products
        List<Product> validProducts = extractor.getValidProducts();
        // ======== TRANSFORM ========
        List<ProductTransformer> transformedProducts = new ArrayList<>();
        for (Product product : validProducts) {
            ProductTransformer transformer = new ProductTransformer(product);
            transformer.transform();
            transformedProducts.add(transformer);
        }
        // ======== LOAD ========
        ProductLoader loader = new ProductLoader();
        loader.upload(transformedProducts);
        // ======== SUMMARY ========
        loader.printSummary(
                extractor.getTotalLines(),
                extractor.getInvalidCount()
        );
    }
}