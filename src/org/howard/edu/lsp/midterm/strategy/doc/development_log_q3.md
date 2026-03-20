This is a ChatGPT Log
Lets move on to question 3:
Question 3 - Refactoring to Use a Design Pattern (30 points)
The following class calculates final prices for customer purchases. Although the code works, the design makes the system difficult to extend and maintain. Study the code carefully and answer the questions that follow.
Provided Class

package org.howard.edu.lsp.midterm.strategy;

public class PriceCalculator {

    public double calculatePrice(String customerType, double price) {

        double finalPrice = price;

        if (customerType.equals("REGULAR")) {
            finalPrice = price;
        }

        if (customerType.equals("MEMBER")) {
            finalPrice = price * 0.90;
        }

        if (customerType.equals("VIP")) {
            finalPrice = price * 0.80;
        }

        if (customerType.equals("HOLIDAY")) {
            finalPrice = price * 0.85;
        }

        return finalPrice;
    }
}

Part 1 - Design Evaluation (8 points)
Evaluate the design of the PriceCalculator class. Explain why the current implementation may lead to maintenance or extensibility problems as the system evolves.
Your answer must be written in a Markdown file named: design_evaluation.md
Place the file in the package:
org.howard.edu.lsp.midterm.strategy.doc
Part 2 - Refactoring Using a Design Pattern (10 points)
Refactor the provided design to use the Strategy Pattern discussed during lecture.
Your refactored implementation must be placed in the package:
org.howard.edu.lsp.midterm.strategy
Each class must be placed in its own .java file. Your implementation should demonstrate the use of the Strategy design pattern to support different discount behaviors.
All classes and public methods must include Javadoc comments.
Part 3 - Driver Program (5 points)
Create a Driver class that demonstrates that your Strategy Pattern implementation works correctly.
Your Driver class must be placed in the package:
org.howard.edu.lsp.midterm.strategy
Your driver must demonstrate the following cases using a purchase price of 100.0:
• REGULAR customer
• MEMBER customer
• VIP customer
• HOLIDAY customer
Your driver must produce output in the following format:
REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0
The output must be produced by executing your Strategy-based implementation, not by hardcoding the results.
Part 4 - Development Log (5 points)
Create a Markdown file named development_log_q3.md
Place the file in the package:
org.howard.edu.lsp.midterm.strategy.doc
This file must document any external resources used while completing this question, including AI tools, internet searches, documentation, lecture notes, or textbooks.
For each resource used, include what you searched or asked and how the information helped you complete the problem. If no external assistance was used, clearly state that in the file.
Grading Rubric (30 points)
Component	Points
Design evaluation (design_evaluation.md)	8
Correct refactoring using Strategy Pattern	10
Driver execution and required output	5
Javadoc documentation in classes and public methods	2
Development log documenting AI/internet use	5

Yep — this one is almost certainly about the Strategy Pattern from your slides.

The current PriceCalculator is the classic “replace conditionals with strategies” setup.

What’s wrong with the current design

Right now, PriceCalculator has discount behavior hardcoded with a chain of if statements.

That creates a few problems:

every time a new customer type is added, you must modify PriceCalculator

discount logic is not encapsulated into separate classes

the class is tightly coupled to all pricing rules

it does not follow the design idea of encapsulate what varies

it will get messier as more customer types or discount rules are added

That is exactly why Strategy fits here:

define a common discount interface

create one class per discount behavior

let PriceCalculator use a strategy object instead of if chains

Likely class design

A clean version would be:

DiscountStrategy interface

RegularDiscount

MemberDiscount

VipDiscount

HolidayDiscount

PriceCalculator

Driver

How the pattern works here

Each strategy class would implement something like:

public interface DiscountStrategy {
    double applyDiscount(double price);
}

Then:

RegularDiscount returns price

MemberDiscount returns price * 0.90

VipDiscount returns price * 0.80

HolidayDiscount returns price * 0.85

Then PriceCalculator holds a DiscountStrategy and delegates to it.

That matches your Strategy slides really well:

encapsulate what varies

code to an interface

favor delegation over inheritance

Best order to do Question 3

We should do it in this order:

design_evaluation.md

DiscountStrategy + concrete strategy classes

PriceCalculator

Driver

development_log_q3.md

The most important conceptual step is locking down the class design before coding.

Say:
“Start with design_evaluation.md”
or
“Let’s code the Strategy classes first”

what should the file paths look like 

Good — getting the file paths right is easy points.

Here’s exactly how your structure should look for Question 3.

📁 Root Structure
org/
└── howard/
    └── edu/
        └── lsp/
            └── midterm/
                └── strategy/
✅ Java Classes (Strategy Implementation)

All Java files go in:

org/howard/edu/lsp/midterm/strategy/
Files you should have:
strategy/
├── DiscountStrategy.java
├── RegularDiscount.java
├── MemberDiscount.java
├── VipDiscount.java
├── HolidayDiscount.java
├── PriceCalculator.java
├── Driver.java
📝 Package statement for ALL Java files

At the top of every .java file:

package org.howard.edu.lsp.midterm.strategy;
📄 Documentation Files

These go in a doc subfolder:

org/howard/edu/lsp/midterm/strategy/doc/
Files:
doc/
├── design_evaluation.md
├── development_log_q3.md
❗ Important Distinction
File Type	Needs package line?
.java	✅ YES
.md	❌ NO
🔥 Full Final Structure
org/howard/edu/lsp/midterm/strategy/
│
├── DiscountStrategy.java
├── RegularDiscount.java
├── MemberDiscount.java
├── VipDiscount.java
├── HolidayDiscount.java
├── PriceCalculator.java
├── Driver.java
│
└── doc/
    ├── design_evaluation.md
    └── development_log_q3.md
⚠️ Common mistakes to avoid

❌ putting .md files in the main folder

❌ forgetting the doc/ subdirectory

❌ adding package line to .md files

❌ inconsistent package names across Java files

✅ Quick sanity check

If you can run:

new PriceCalculator(...)

and your Driver compiles, your structure is correct.

If you want, next we can:
👉 write design_evaluation.md (quick win, only 8 points but easy)
👉 OR jump straight into coding the Strategy pattern classes

lets start with part 1 these are my thoughts:
it might lead to maintenance or extensibility problems as the system evolves because what if new tiers are added or if the customer types become more robust like if you have been a regular member for such amount of time you get a higher discount and eventually you get upgraded to member issues like that 

That’s a solid starting point. Your instinct is right: the biggest issue is that the current design does not handle change well.

Here’s how I’d sharpen your idea for Part 1.

What you already identified correctly

You noticed that if:

new customer tiers are added

discount rules become more complex

discounts depend on time, history, or changing business rules

then the current PriceCalculator becomes harder to maintain.

That is exactly the core problem.

What to add

To make it stronger, connect your thought to the design principles from class:

the class uses a chain of if statements instead of separate objects

discount behavior is not encapsulated

the class must be modified every time a new pricing rule is introduced

this violates the idea of encapsulate what varies

it creates tight coupling between PriceCalculator and every discount rule

the design becomes less extensible over time

So your idea can become:

The current implementation may lead to maintenance and extensibility problems because all discount behavior is hardcoded inside one method. If new customer tiers or more detailed discount rules are added, the class must keep being modified, which increases complexity and makes the design harder to extend. This also means the class is tightly coupled to all pricing rules instead of delegating each discount behavior to a separate strategy.

A clean design_evaluation.md version

You said you like bullets with an intro and conclusion, so here’s a version in that style:

The current `PriceCalculator` design works for a small number of customer types, but it may lead to maintenance and extensibility problems as the system evolves. Because all discount rules are hardcoded inside a single method, the class becomes harder to modify, test, and extend when new pricing behaviors are introduced. The main design issues are listed below:

- **Hardcoded pricing logic**: The discount rules for REGULAR, MEMBER, VIP, and HOLIDAY customers are all embedded directly inside `calculatePrice()`. This means the class is responsible for every discount rule in the system.

- **Poor extensibility**: If a new customer tier is added, or if discount rules become more complex, such as loyalty-based discounts or seasonal promotions, the `PriceCalculator` class must be modified. This makes the design harder to extend as business requirements change.

- **Violates encapsulate what varies**: The part of the system that changes most often is the discount behavior, but it is not separated into its own classes. Instead, all variations are placed in one method, which makes the design less flexible.

- **Tight coupling to pricing rules**: `PriceCalculator` is directly dependent on every customer type and discount rule. As more cases are added, the class becomes more tightly coupled to the details of discount calculation.

- **Reduced maintainability**: Over time, adding more conditions will make the method longer, more error-prone, and harder to read. This increases the chance of introducing bugs when the pricing logic is updated.

In conclusion, the current design is functional but not well structured for change. Refactoring the system to use the Strategy Pattern would improve flexibility by separating each discount behavior into its own class and allowing `PriceCalculator` to delegate pricing decisions instead of hardcoding them.

This is strong because it directly sets up the Strategy Pattern answer in Part 2.

If you want, next we should move straight into the actual class design for the Strategy Pattern.

Lets move on to part 2

Perfect. For Part 2, we want a clean Strategy Pattern design that matches your lecture slides:

encapsulate what varies

code to an interface

favor delegation over inheritance

The pattern here

What varies is the discount behavior.

So instead of one PriceCalculator with a bunch of if statements, we create:

one common interface for discount behavior

one class per discount type

a PriceCalculator that delegates to the chosen strategy

Classes you should create

Inside:

org/howard/edu/lsp/midterm/strategy/

Create:

DiscountStrategy.java
RegularDiscount.java
MemberDiscount.java
VipDiscount.java
HolidayDiscount.java
PriceCalculator.java
Driver.java
1. DiscountStrategy.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * Defines the strategy interface for applying discounts.
 *
 * @author Nicholas Abram
 */
public interface DiscountStrategy {

    /**
     * Applies a discount strategy to the given price.
     *
     * @param price the original purchase price
     * @return the final price after applying the discount
     */
    double calculatePrice(double price);
}
2. RegularDiscount.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * Represents the pricing strategy for regular customers.
 *
 * @author Nicholas Abram
 */
public class RegularDiscount implements DiscountStrategy {

    /**
     * Returns the original price with no discount applied.
     *
     * @param price the original purchase price
     * @return the unchanged price
     */
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}
3. MemberDiscount.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * Represents the pricing strategy for member customers.
 *
 * @author Nicholas Abram
 */
public class MemberDiscount implements DiscountStrategy {

    /**
     * Applies a 10% discount to the original price.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}
4. VipDiscount.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * Represents the pricing strategy for VIP customers.
 *
 * @author Nicholas Abram
 */
public class VipDiscount implements DiscountStrategy {

    /**
     * Applies a 20% discount to the original price.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}
5. HolidayDiscount.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * Represents the pricing strategy for holiday customers.
 *
 * @author Nicholas Abram
 */
public class HolidayDiscount implements DiscountStrategy {

    /**
     * Applies a 15% discount to the original price.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
6. PriceCalculator.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * Calculates final prices by delegating to a discount strategy.
 *
 * @author Nicholas Abram
 */
public class PriceCalculator {
    private DiscountStrategy discountStrategy;

    /**
     * Constructs a PriceCalculator with the given discount strategy.
     *
     * @param discountStrategy the discount strategy to use
     */
    public PriceCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Calculates the final price using the current discount strategy.
     *
     * @param price the original purchase price
     * @return the final price after discount
     */
    public double calculatePrice(double price) {
        return discountStrategy.calculatePrice(price);
    }
}
Why this is a real Strategy Pattern

Because now PriceCalculator does not know the details of:

regular discount

member discount

VIP discount

holiday discount

It only knows:

DiscountStrategy

That is the “code to an interface” part.

And the discount behavior can change by passing in a different strategy object.

One important thought

You could also add a setter like:

public void setDiscountStrategy(DiscountStrategy discountStrategy)

to let the calculator change strategies at runtime.

That would still be good Strategy Pattern design.

But for this exam, it is not required unless you want to show extra flexibility.

Next step

The only coding piece left after this is the Driver.java, which is straightforward and needs to print:

REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0

Paste your PriceCalculator thoughts if you want to sanity-check the design before we do the driver.

According to the patterns-part-1 slides the strategy pattern is defined by: How does this compare to your understanding

This is actually a really good moment—you’re connecting lecture definition → implementation, which is exactly what your professor wants.

✅ Short Answer

My explanation matches your slide almost exactly, just applied to your specific problem.

🔍 Let’s break the slide down and map it to your code
📌 Slide Definition

“The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.”

🧠 In YOUR implementation
Slide Concept	Your Code
Family of algorithms	RegularDiscount, MemberDiscount, VipDiscount, HolidayDiscount
Encapsulates each one	Each discount is its own class
Interchangeable	You can swap strategies in PriceCalculator
🔥 Line-by-line comparison
1. “Encapsulate what varies”

👉 What varies?
Discount logic

✔️ You did this:

Each discount is in its own class

2. “Code to an Interface”

👉 Instead of:

if (customerType.equals(...))

✔️ You now use:

DiscountStrategy

That’s exactly:

code to an abstraction, not a concrete implementation

3. “Delegation”

👉 Instead of doing the work itself:

PriceCalculator → delegates → DiscountStrategy

✔️ Your design:

return discountStrategy.calculatePrice(price);
4. “Favor Delegation over Inheritance”

You did NOT do:

class VipCalculator extends PriceCalculator

✔️ Instead:

You used composition (has-a relationship)

That’s exactly what the slide wants.

5. “Algorithms vary independently from clients”

👉 Client = PriceCalculator

Now:

You can add a new discount WITHOUT touching PriceCalculator

That is the biggest win.

🎯 The only small enhancement (optional insight)

Right now, your implementation uses:

new PriceCalculator(new VipDiscount());

That’s good.

But you could go further by allowing dynamic switching:

calculator.setStrategy(new HolidayDiscount());

That would fully emphasize interchangeability.

🧠 Final takeaway (exam-ready sentence)

If you had to explain this in one line:

The Strategy Pattern is used here by encapsulating each discount calculation into separate classes that implement a common interface, allowing the pricing algorithm to vary independently from the PriceCalculator.

🔥 Verdict

✔️ Your implementation is fully aligned with the slide definition
✔️ You correctly applied:

encapsulation

abstraction

delegation

interchangeability

If you want next:
👉 we can write the Driver.java (quick 5 points)
👉 or polish Javadoc to make sure you don’t lose easy points

Ok I want you to regen the classes with good Javadocs

Perfect—this is where you can pick up easy points. I’ll give you clean, professor-level Javadocs that match the rubric (class description + method descriptions with @param and @return).

✅ DiscountStrategy.java
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
✅ RegularDiscount.java
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
✅ MemberDiscount.java
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
✅ VipDiscount.java
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
✅ HolidayDiscount.java
package org.howard.edu.lsp.midterm.strategy;

/**
 * Represents the pricing strategy for holiday promotions.
 * Applies a 15% discount to the original price.
 * 
 * @author Nicholas Abram
 */
public class HolidayDiscount implements DiscountStrategy {

    /**
     * Applies a 15% discount to the given price.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
✅ PriceCalculator.java
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
🔥 Why these Javadocs are strong

They satisfy ALL rubric requirements:

✔️ Class-level description

✔️ Author tag

✔️ Method descriptions

✔️ @param for inputs

✔️ @return for outputs

✔️ Clear explanation of purpose

🎯 Next step

Only thing left is:

👉 Driver.java (super quick, easy 5 points)

Say:
“generate driver” and I’ll give you a clean one that exactly matches expected output.

Does it matter if the class name becomes VIP in regards to java practices as techically VIP is an acryonm

Great question—this is a Java naming convention detail, not a functional issue.

✅ Short Answer

👉 It does not affect functionality at all, but
👉 VipDiscount is preferred over VIPDiscount in standard Java style

🧠 Why

Java follows PascalCase (UpperCamelCase) for class names:

Each word starts with a capital letter, but acronyms are usually treated like normal words

Recommended:
VipDiscount
Not recommended (but still valid):
VIPDiscount
📚 Standard Practice (Important)

In Java:

Acronyms are usually written like words:

HttpClient (not HTTPClient)

XmlParser (not XMLParser)

JsonObject (not JSONOBJECT)

So:

VipDiscount  ✅ (standard)
VIPDiscount  ⚠️ (legal, but not idiomatic)
🎯 Why professors care

Using VipDiscount shows:

you understand Java naming conventions

your code is clean and consistent

you're following industry standards

🔥 When WOULD you use all caps?

Only for:

constants:

public static final double TAX_RATE = 0.07;

NOT class names.

✅ Final Recommendation

Stick with:

VipDiscount

That is the correct, expected, and safest choice for grading.

If you want, next I can:
👉 generate the Driver.java
👉 or do a final checklist before you submit everything

Ok cool lets head to part 3

Here’s a clean Driver.java that uses your Strategy Pattern implementation and prints the required output.

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
Expected output
REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0

This works because the output is produced by actually calling each strategy through PriceCalculator, not by hardcoding the numbers.

The only thing left after this is development_log_q3.md.