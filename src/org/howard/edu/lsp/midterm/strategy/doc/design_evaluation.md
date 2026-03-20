The current `PriceCalculator` design works for a small number of customer types, but it may lead to maintenance and extensibility problems as the system evolves. Because all discount rules are hardcoded inside a single method, the class becomes harder to modify, test, and extend when new pricing behaviors are introduced. The main design issues are listed below:

- **Hardcoded pricing logic**: The discount rules for REGULAR, MEMBER, VIP, and HOLIDAY customers are all embedded directly inside `calculatePrice()`. This means the class is responsible for every discount rule in the system.

- **Poor extensibility**: If a new customer tier is added, or if discount rules become more complex, such as loyalty-based discounts or seasonal promotions, the `PriceCalculator` class must be modified. This makes the design harder to extend as business requirements change.

- **Violates encapsulate what varies**: The part of the system that changes most often is the discount behavior, but it is not separated into its own classes. Instead, all variations are placed in one method, which makes the design less flexible.

- **Tight coupling to pricing rules**: `PriceCalculator` is directly dependent on every customer type and discount rule. As more cases are added, the class becomes more tightly coupled to the details of discount calculation.

- **Reduced maintainability**: Over time, adding more conditions will make the method longer, more error-prone, and harder to read. This increases the chance of introducing bugs when the pricing logic is updated.

In conclusion, the current design is functional but not well structured for change. Refactoring the system to use the Strategy Pattern would improve flexibility by separating each discount behavior into its own class and allowing `PriceCalculator` to delegate pricing decisions instead of hardcoding them.