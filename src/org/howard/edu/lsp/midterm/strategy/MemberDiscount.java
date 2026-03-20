package org.howard.edu.lsp.midterm.strategy;

/**
 * Represents the pricing strategy for member customers.
 * Applies a 10% discount to the original price.
 * 
 * @author Nicholas Abram
 */
public class MemberDiscount implements DiscountStrategy {

    /**
     * Applies a 10% discount to the given price.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}