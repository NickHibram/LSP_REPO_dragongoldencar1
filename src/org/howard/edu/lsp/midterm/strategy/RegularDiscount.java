package org.howard.edu.lsp.midterm.strategy;

/**
 * Represents the pricing strategy for regular customers with no discount.
 * 
 * @author Nicholas Abram
 */
public class RegularDiscount implements DiscountStrategy {

    /**
     * Returns the original price without any discount.
     *
     * @param price the original purchase price
     * @return the unchanged price
     */
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}