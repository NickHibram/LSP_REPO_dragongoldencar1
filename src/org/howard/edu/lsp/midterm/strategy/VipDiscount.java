package org.howard.edu.lsp.midterm.strategy;

/**
 * Represents the pricing strategy for VIP customers.
 * Applies a 20% discount to the original price.
 * 
 * @author Nicholas Abram
 */
public class VipDiscount implements DiscountStrategy {

    /**
     * Applies a 20% discount to the given price.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}