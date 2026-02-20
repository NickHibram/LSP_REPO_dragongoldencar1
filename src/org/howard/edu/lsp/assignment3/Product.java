package org.howard.edu.lsp.assignment3;
    /**
 * Name: Nicholas Abram
 */
/**
 * Represents a product with an ID, name, price, and category.
 * Tracks whether the product is valid for transformation and loading.
 */
public class Product {
    /** The unique identifier for the product. */
    private int productId;
    /** The name of the product. */
    private String name;
    /** The price of the product. */
    private double price;
    /** The category the product belongs to. */
    private String category;
    /** Indicates whether the product has been validated. */
    private boolean isValid;
    /**
     * Constructs a Product with the given fields.
     * isValid defaults to false until explicitly validated.
     *
     * @param productId the unique identifier for the product
     * @param name the name of the product
     * @param price the price of the product
     * @param category the category of the product
     */
    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.isValid = false;
    }
    /**
     * Returns the product ID.
     *
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }
    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the product price.
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }
    /**
     * Returns the product category.
     *
     * @return the product category
     */
    public String getCategory() {
        return category;
    }
    /**
     * Returns whether the product is valid.
     *
     * @return true if the product is valid; false otherwise
     */
    public boolean isValid() {
        return isValid;
    }
    /**
     * Sets the product ID.
     *
     * @param productId the new product ID
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }
    /**
     * Sets the product name.
     *
     * @param name the new product name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the product price.
     *
     * @param price the new product price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Sets the product category.
     *
     * @param category the new product category
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * Sets whether the product is valid.
     *
     * @param isValid true to mark the product as valid; false otherwise
     */
    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }
    /**
     * Returns a formatted string representation of the product.
     * The price is formatted to two decimal places.
     *
     * @return a formatted string describing the product
     */
    @Override
    public String toString() {
        return "Product{id=" + productId +
                ", name=" + name +
                ", price=" + String.format("%.2f", price) +
                ", category=" + category +
                ", valid=" + isValid + "}";
    }
    /**
     * Returns a CSV-formatted string representation of the product.
     * The price is formatted to two decimal places.
     *
     * @return a CSV string in the format: productId,name,price,category
     */
    public String toCSVString() {
        return productId + "," +
                name + "," +
                String.format("%.2f", price) + "," +
                category;
    }
}