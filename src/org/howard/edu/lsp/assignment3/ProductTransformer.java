package org.howard.edu.lsp.assignment3;
    /**
 * Name: Nicholas Abram
 */
import java.io.BufferedReader;

/**
 * ProductTransformer extends Product and applies business transformation
 * rules in a specific required order.
 *
 * Transformations:
 * 1. Convert name to uppercase
 * 2. Apply 10% discount if category is "Electronics"
 * 3. Round price to two decimal places
 * 4. If original category was "Electronics" and final price > 500,
 *    change category to "Premium Electronics"
 * 5. Determine price range
 */
public class ProductTransformer extends Product {

    /** Stores the calculated price range */
    private String priceRange;

    /** Stores original category before any modifications */
    private String originalCategory;

    /**
     * Constructs a ProductTransformer using an existing Product.
     *
     * @param product the Product to transform
     */
    public ProductTransformer(Product product) {
        super(product.getProductId(),
              product.getName(),
              product.getPrice(),
              product.getCategory());
        this.originalCategory = product.getCategory();
        this.priceRange = null;
    }

    /**
     * Public facade method that applies all transformations
     * in the required order.
     */
    public void transform() {
        uppercaseName();
        applyDiscount();
        roundPrice();
        applyPremiumCategory();
        calculatePriceRange();
    }

    /**
     * Converts the product name to uppercase.
     */
    private void uppercaseName() {
        setName(getName().toUpperCase());
    }

    /**
     * Applies a 10% discount if category is "Electronics".
     */
    private void applyDiscount() {
        if (getCategory().equals("Electronics")) {
            setPrice(getPrice() * 0.90);
        }
    }

    /**
     * Rounds the price to two decimal places.
     */
    private void roundPrice() {
        double rounded = Math.round(getPrice() * 100.0) / 100.0;
        setPrice(rounded);
    }

    /**
     * If original category was "Electronics" AND
     * final price is strictly greater than 500,
     * change category to "Premium Electronics".
     */
    private void applyPremiumCategory() {
        if (originalCategory.equals("Electronics") && getPrice() > 500) {
            setCategory("Premium Electronics");
        }
    }

    /**
     * Determines the price range based on final price.
     */
    private void calculatePriceRange() {
        double price = getPrice();
        if (price <= 10) {
            priceRange = "Low";
        } else if (price <= 100) {
            priceRange = "Medium";
        } else if (price <= 500) {
            priceRange = "High";
        } else {
            priceRange = "Premium";
        }
    }

    /**
     * Returns the calculated price range.
     *
     * @return priceRange
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Sets the price range manually.
     *
     * @param priceRange the price range to set
     */
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    /**
     * Returns the original category before any transformations.
     *
     * @return originalCategory
     */
    public String getOriginalCategory() {
        return originalCategory;
    }

    /**
     * Returns the transformed product data in CSV format,
     * including the calculated price range.
     *
     * Format: ProductID,Name,Price,Category,PriceRange
     *
     * @return a CSV-formatted string representing the transformed product
     */
    @Override
    public String toCSVString() {
        return getProductId() + "," +
               getName() + "," +
               String.format("%.2f", getPrice()) + "," +
               getCategory() + "," +
               priceRange;
    }
}