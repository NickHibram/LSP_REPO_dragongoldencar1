package org.howard.edu.lsp.midterm.strategy;

/**
 * Defines a strategy interface for applying different discount algorithms.
 * Implementations of this interface encapsulate specific pricing behaviors.
 * 
 * @author Nicholas Abram
 */
public interface DiscountStrategy {

    /**
     * Calculates the final price after applying a discount strategy.
     *
     * @param price the original purchase price
     * @return the final price after applying the discount
     */
    double calculatePrice(double price);
}