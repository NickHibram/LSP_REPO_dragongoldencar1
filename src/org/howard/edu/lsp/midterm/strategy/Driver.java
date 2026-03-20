package org.howard.edu.lsp.midterm.strategy;

/**
 * Demonstrates the Strategy Pattern implementation for price calculation
 * using different customer discount strategies.
 *
 * @author Nicholas Abram
 */
public class Driver {

    /**
     * Runs the driver program to test all required discount strategies.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        double price = 100.0;

        PriceCalculator regularCalculator = new PriceCalculator(new RegularDiscount());
        PriceCalculator memberCalculator = new PriceCalculator(new MemberDiscount());
        PriceCalculator vipCalculator = new PriceCalculator(new VipDiscount());
        PriceCalculator holidayCalculator = new PriceCalculator(new HolidayDiscount());

        System.out.println("REGULAR: " + regularCalculator.calculatePrice(price));
        System.out.println("MEMBER: " + memberCalculator.calculatePrice(price));
        System.out.println("VIP: " + vipCalculator.calculatePrice(price));
        System.out.println("HOLIDAY: " + holidayCalculator.calculatePrice(price));
    }
}