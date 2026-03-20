package org.howard.edu.lsp.midterm.strategy;

/**
 * Calculates final prices by delegating discount logic to a DiscountStrategy.
 * This class demonstrates the Strategy Design Pattern by allowing the pricing
 * algorithm to vary independently from the client.
 * 
 * @author Nicholas Abram
 */
public class PriceCalculator {

    private DiscountStrategy discountStrategy;

    /**
     * Constructs a PriceCalculator with a specified discount strategy.
     *
     * @param discountStrategy the strategy used to calculate the final price
     */
    public PriceCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Calculates the final price using the current discount strategy.
     *
     * @param price the original purchase price
     * @return the final price after applying the discount
     */
    public double calculatePrice(double price) {
        return discountStrategy.calculatePrice(price);
    }

    /**
     * Updates the discount strategy at runtime.
     *
     * @param discountStrategy the new discount strategy to apply
     */
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
}