This is a ChatGPT Log

This is question 2:
Question 2 - Evaluating Object-Oriented Design (30 points)
The following class is part of a simple order processing system. The design of this class violates several object-oriented design ideas discussed in class, including principles described in Arthur Riel’s object-oriented design heuristics. Study the code carefully and answer the questions that follow.
Provided Class

import java.io.FileWriter;
import java.util.Date;

public class OrderProcessor {

    // Order data (poor encapsulation)
    public String customerName;
    public String email;
    public String item;
    public double price;

    public void processOrder() {

        // calculate tax
        double tax = price * 0.07;
        double total = price + tax;

        // print receipt
        System.out.println("Customer: " + customerName);
        System.out.println("Item: " + item);
        System.out.println("Total: " + total);

        // save order to file
        try {
            FileWriter writer = new FileWriter("orders.txt", true);
            writer.write(customerName + "," + item + "," + total + "\n");
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        // send confirmation email
        System.out.println("Sending confirmation email to " + email);

        // apply discount
        if(price > 500) {
            total = total * 0.9;
        }

        // log activity
        System.out.println("Order processed at " + new Date());
    }
}

Part 1 - Design Evaluation (15 points)
Evaluate the design of the OrderProcessor class. Based on the object-oriented design principles discussed in class, describe the design issues you observe in this class. Explain why the design may lead to poor object-oriented structure, maintainability, or extensibility. You may reference ideas from Arthur Riel’s design heuristics, but exact terminology is not required.
Your answer must be written in a Markdown file named: evaluation.md
Place the file in the directory:
org/howard/edu/lsp/midterm/design/doc
Part 2 - Proposed Improved Design Using CRC Cards (10 points)
Redesign the system to improve its object-oriented structure. Express your proposed design using CRC cards (Class–Responsibility–Collaborator). Your CRC cards should identify the major components of the redesigned system and how responsibilities are distributed among them.
Your answer must be written in a Markdown file named: design.md
Place the file in the directory:
org/howard/edu/lsp/midterm/design/doc
Each CRC card should follow this format:
Class:
Responsibilities:
Collaborators:
Part 3 - Development Log (5 points)
Create a Markdown file named development_log_q2.md and place it in:
org/howard/edu/lsp/midterm/design/doc

This file must document any external resources used while completing this question, including AI tools, internet searches, documentation, lecture notes, or textbooks. For each resource used include what you searched or asked and how the information helped you complete the problem. If no external assistance was used, clearly state that in the file.
Grading Rubric (30 points)
Component	Points
Design evaluation and explanation	15
CRC-based redesigned architecture (design.md)	10
Development log documenting AI/internet use	5
 

Yep — this one is mostly a design critique + redesign question, not coding.

Here’s the big picture before we write anything.

What Question 2 is asking

You need to produce 3 markdown files:

org/howard/edu/lsp/midterm/design/doc/
    evaluation.md
    design.md
    development_log_q2.md

And the work is split into 3 parts:

evaluation.md

Explain what is wrong with OrderProcessor.

design.md

Propose a better object-oriented design using CRC cards.

development_log_q2.md

Document any help/resources used.

What is wrong with OrderProcessor

This class is bad OO design because it does too many jobs.

Right now one class is responsible for:

storing order/customer data

calculating tax

applying discount

printing receipt

writing to a file

sending email

logging activity

That violates ideas from your slides like:

one class should capture one key abstraction

avoid god classes

keep data and behavior well organized

use encapsulation

distribute responsibilities instead of centralizing everything

This is very similar to the “god class / controller class” warnings from your heuristics slides.

The main design issues you should talk about

These are the points I would definitely include in evaluation.md:

1. Poor encapsulation

The fields are public:

public String customerName;
public String email;
public String item;
public double price;

That means any class can directly change them.
Good OO design usually hides data inside the class.

2. Too many responsibilities

processOrder() does many unrelated things.

So the class has low cohesion and is trying to be:

order calculator

receipt printer

file saver

email sender

logger

all at once.

3. God class / centralized control

This class controls the entire workflow itself.

Instead of having separate objects collaborate, one class is doing everything. That’s the kind of centralized design your heuristics warned against.

4. Hard to maintain

If you want to:

change tax rules

change discount logic

save to database instead of file

send real email instead of console output

change receipt format

you must edit the same class.

That makes the system harder to extend and maintain.

5. Tight coupling to specific implementation details

It directly uses:

FileWriter

console printing

Date

So it is tightly coupled to file storage and console-based output.

6. Weak extensibility

If later you want:

multiple discount strategies

different storage methods

different notification methods

this design will become messy fast.

7. Discount logic is in a strange place

It prints/saves the total before applying the discount.

So even behaviorally, the order of operations is questionable.

That’s a nice extra observation.

What a better OO redesign would look like

You want to split responsibilities into classes.

A solid redesign could use classes like:

Order

OrderProcessor

TaxCalculator

DiscountPolicy

ReceiptPrinter

OrderRepository

EmailService

ActivityLogger

Why this is better

Each class has one main responsibility.

Then OrderProcessor becomes more of a coordinator, but not a giant all-in-one class.

Strong CRC card candidates

You do not need to overdo it. Keep it clean.

Option A: Strong, balanced redesign

Use these classes:

Order

OrderProcessor

TaxCalculator

DiscountPolicy

ReceiptPrinter

OrderRepository

NotificationService

ActivityLogger

That is probably the best version.

How I would describe each class
Order

Stores order data like customer name, email, item, and price.

OrderProcessor

Coordinates the order-processing workflow by using the collaborator classes.

TaxCalculator

Calculates tax and total.

DiscountPolicy

Determines whether a discount applies and calculates the discounted total.

ReceiptPrinter

Displays or formats the receipt.

OrderRepository

Saves order information.

NotificationService

Sends confirmation messages.

ActivityLogger

Logs order activity.

Best strategy for answering

We should do this in order:

Draft evaluation.md

Draft design.md

Draft development_log_q2.md

The most important one is evaluation.md, because that’s worth the most points.

Suggested starting point

For evaluation.md, your professor likely wants a paragraph-style explanation, not just bullets.

A strong answer should mention:

poor encapsulation

too many responsibilities / low cohesion

god class / centralized control

tight coupling

poor maintainability/extensibility

If you want, next I’ll write a clean evaluation.md draft that sounds like a strong exam answer.

Ok let's start with part 1 

Here’s a strong evaluation.md draft you can use and then tweak to sound more like you.

The `OrderProcessor` class has several object-oriented design problems because it combines too many unrelated responsibilities into one class. In addition to storing order data, it calculates tax, applies discounts, prints a receipt, writes order information to a file, sends a confirmation email, and logs activity. This creates a low-cohesion design because one class is trying to manage many different parts of the system instead of focusing on a single key abstraction.

The class also demonstrates poor encapsulation because its data fields (`customerName`, `email`, `item`, and `price`) are declared `public`. This allows other parts of the program to directly access and modify the internal state of the object, which makes the design harder to control and maintain. A better object-oriented design would hide this data inside the class and provide controlled access through methods.

Another major issue is that `OrderProcessor` behaves like a god class or centralized controller. Rather than distributing responsibilities across collaborating objects, it controls the entire order workflow by itself. This kind of design is harder to extend because any change to tax calculation, discount rules, receipt formatting, file storage, email delivery, or logging would require modifying the same class. As a result, the class is tightly coupled to many implementation details, including console output, file handling, and the current logging and notification approach.

The design also reduces extensibility. For example, if the system later needs to save orders to a database instead of a text file, support different discount policies, or send real email notifications, the current class would need to be heavily rewritten. A more object-oriented design would separate these concerns into distinct classes so that each class has a focused responsibility and the system can evolve more easily.

Finally, the current logic also suggests a behavioral design issue: the receipt is printed and the order is saved before the discount is applied. This can lead to inconsistent or incorrect results. Overall, the class violates key object-oriented ideas such as encapsulation, clear responsibility distribution, and low coupling, which makes the design less maintainable, less reusable, and harder to extend.

This is good because it hits the major points your slides support:

encapsulation/data hiding

one key abstraction

avoid god classes

low coupling / high cohesion

maintainability and extensibility

If you want, I can make this sound a little more like your writing style instead of sounding polished-professor style.

Before I go off of what you're saying I am going to come up with points I think and then we will compare and contrast

That’s exactly the right approach 💯 — this is how you actually learn + secure points, not just copy.

Here’s how I want you to do it so we can maximize your score:

🧠 Step 1: Write your points (don’t overthink)

Just list things like:

what feels wrong

what seems messy

what violates what you remember from class

Even if it’s rough like:

“this class does too much”
“everything is public”
“it handles file + email + logic”

That’s perfect.

🔍 Step 2: I’ll help you map your ideas to:

OO principles (encapsulation, cohesion, coupling)

Riel heuristics (god class, responsibility distribution)

grading language (what professors want to see)

🎯 What we’ll do together after

I’ll:

Validate your points (what’s correct / missing)

Upgrade wording → make it sound like an A answer

Fill any gaps so you don’t lose easy points

⚠️ Important mindset

Don’t try to sound perfect yet.

Right now your job is:

“What looks wrong about this class?”

Then I’ll turn it into:

“This violates object-oriented design principles such as…”

Drop your list when ready 👇

1. like it says in the comments that is terrible encapsulation the class's raw internal variables need to be private in order to keep the data safe, especailly from getter and setter methods.
2. There is too much happening in one function processOrder it's calculating the tax, printing the reciept, saves it to a new file, sneds a confrimamation email, applies a discount, and logs acivity. This function isn't bad code wize but in regards to OOP this is simply not how it should look like. There should be multiple objects happening in this code there maybe an object that handles money relation where there is a getter/setter for the tax and discount as in the real world those are subject to change. There should be one that holds the customer's information(as well as maybe past orders). There should be an obkect htat handles the filewritting. 
3. Also the discount is applied after the reciept is already printed and saved so it's redundant at the momment it needs to be moved.  

These are good points. You already found the main issues. What you need now is to sharpen them and connect them to OO design language.

What you got right

Your first point is correct: the class has poor encapsulation because the fields are public. One small correction, though: making fields private protects the object from direct outside access; getters and setters do not “keep data safe” by themselves unless they control or validate access. So the stronger idea is that the class should hide its internal state and expose controlled methods only.

Your second point is also strong: processOrder() is doing far too much. That is the biggest design flaw. In OO terms, this means the class has low cohesion and too many responsibilities. It starts to look like a god class or centralized controller, which your slides warned against.

Your third point is an excellent catch because it shows you are evaluating both design and behavior. The discount is applied after the receipt is printed and the order is saved, so the workflow is inconsistent.

What I would add

One more idea to include is maintainability and extensibility. Right now, if the business changes the tax rule, discount rule, storage method, receipt format, or email system, you have to edit the same class. That makes the design tightly coupled and harder to extend.

How your points translate into professor language

Here is the cleaner version of your three ideas:

Poor encapsulation: the class exposes its internal data through public fields instead of hiding it behind a controlled interface.

Too many responsibilities / low cohesion: processOrder() handles calculation, receipt output, file persistence, email notification, discount logic, and logging all in one place instead of distributing work across collaborating classes.

Behavioral/workflow flaw: the discount is applied after the receipt is printed and the order is saved, which can produce incorrect or inconsistent results.

Hard to maintain and extend: changes to pricing rules, storage, notifications, or logging would all force modifications to the same class.

A polished paragraph based on your ideas

You could write Part 1 like this:

The `OrderProcessor` class has poor encapsulation because its internal data fields are declared `public`, which allows other parts of the program to directly access and modify its state. A better object-oriented design would keep these fields private and provide controlled access through methods. The class also has too many responsibilities because `processOrder()` calculates tax, prints a receipt, saves order data to a file, sends a confirmation email, applies a discount, and logs activity all in one place. This creates low cohesion and makes the class resemble a god class rather than a focused object with one key abstraction. In addition, the design is hard to maintain and extend because any change to tax rules, discount policies, file storage, receipt formatting, email delivery, or logging would require modifying the same class. Finally, the discount is applied after the receipt is printed and the order is saved, which can lead to inconsistent or incorrect results. Overall, the class violates object-oriented ideas such as encapsulation, clear responsibility distribution, and low coupling.

That is already strong enough for full-credit style reasoning.

Your instincts were right. The only real upgrade was turning “this is not how OOP should look” into the specific terms: encapsulation, low cohesion, centralized control/god class, maintainability, extensibility.

Send your revised version and I’ll help tighten it before you put it in evaluation.md.

can you utalize bulletpoints I am not a fan of how the output looks 

Got you — bullet points are totally fine as long as your explanations are clear and complete (which yours are). Let’s convert your ideas into a clean, strong bullet-point answer that still sounds like an A-level response.

✅ evaluation.md (Bullet Point Version)
- **Poor Encapsulation**: The class exposes its internal data (`customerName`, `email`, `item`, `price`) as public fields. This allows external code to directly modify the object's state, violating data hiding principles. A better design would make these fields private and provide controlled access through methods.

- **Too Many Responsibilities (Low Cohesion)**: The `processOrder()` method performs multiple unrelated tasks, including calculating tax, printing a receipt, saving data to a file, sending a confirmation email, applying a discount, and logging activity. This violates the idea that a class should represent one key abstraction and have a focused responsibility.

- **God Class / Centralized Control**: The `OrderProcessor` acts as a central controller that handles the entire workflow instead of delegating responsibilities to other classes. This leads to poor distribution of responsibilities and reduces flexibility in the design.

- **Tight Coupling to Implementation Details**: The class is directly tied to specific implementations such as `FileWriter`, console output, and `Date`. This makes it difficult to change how data is stored, displayed, or logged without modifying the class.

- **Poor Maintainability and Extensibility**: Any changes to tax rules, discount policies, file storage, receipt formatting, email delivery, or logging would require modifying this single class. This makes the system harder to maintain and extend over time.

- **Incorrect Workflow / Logic Issue**: The discount is applied after the receipt is printed and the order is saved, which can result in inconsistent or incorrect outputs.
🎯 Why this is strong

Clean and readable ✔️

Uses OO terminology your professor expects ✔️

Directly tied to the code ✔️

Covers all major issues ✔️

⚠️ One quick tip

Some professors prefer paragraphs, but bullet points are usually fine if:

each bullet has a full explanation (you do ✔️)

you’re not just listing keywords

If you’re ready, next we can do Part 2 (CRC redesign) — that’s where you can pick up easy structured points.

Ok but I want a opening couple of sentences before we go over each one in particular and I want a conclusion as well

Perfect—that’s exactly how to make it feel polished and intentional while still using bullets.

Here’s a strong intro + bullets + conclusion version you can use:

✅ Final evaluation.md
The `OrderProcessor` class demonstrates several object-oriented design issues that negatively impact its structure, maintainability, and extensibility. By combining multiple responsibilities into a single class and exposing its internal data, the design violates key object-oriented principles such as encapsulation and proper responsibility distribution. The main issues are outlined below:

- **Poor Encapsulation**: The class exposes its internal data (`customerName`, `email`, `item`, `price`) as public fields. This allows external code to directly modify the object's state, violating data hiding principles. A better design would make these fields private and provide controlled access through methods.

- **Too Many Responsibilities (Low Cohesion)**: The `processOrder()` method performs multiple unrelated tasks, including calculating tax, printing a receipt, saving data to a file, sending a confirmation email, applying a discount, and logging activity. This violates the idea that a class should represent one key abstraction and have a focused responsibility.

- **God Class / Centralized Control**: The `OrderProcessor` acts as a central controller that handles the entire workflow instead of delegating responsibilities to other classes. This leads to poor distribution of responsibilities and reduces flexibility in the design.

- **Tight Coupling to Implementation Details**: The class is directly tied to specific implementations such as `FileWriter`, console output, and `Date`. This makes it difficult to change how data is stored, displayed, or logged without modifying the class.

- **Poor Maintainability and Extensibility**: Any changes to tax rules, discount policies, file storage, receipt formatting, email delivery, or logging would require modifying this single class. This makes the system harder to maintain and extend over time.

- **Incorrect Workflow / Logic Issue**: The discount is applied after the receipt is printed and the order is saved, which can result in inconsistent or incorrect outputs.

In conclusion, the `OrderProcessor` class violates several core object-oriented design principles, including encapsulation, low coupling, and proper responsibility distribution. Refactoring this design to separate concerns across multiple classes would result in a more maintainable, flexible, and extensible system.
🔥 Why this is A-level

Strong opening framing the critique

Clear structured breakdown

Uses terminology from your slides (encapsulation, cohesion, coupling)

Clean closing that answers “why it matters”

If you’re ready, let’s move to Part 2 (CRC cards redesign)—that’s where you can really show design understanding.

What is the main difference between the tight coupling and maintainability points

Great question — this is exactly the kind of distinction professors test.

🔑 Core Difference (Simple)

Tight coupling = how dependent classes are on specific implementations

Maintainability = how easy the system is to change over time

👉 Tight coupling is a cause
👉 Poor maintainability is an effect

🧠 In the context of your code
🔗 Tight Coupling (the design problem)

This class is directly tied to:

FileWriter (file storage)

System.out.println (console output)

Date (logging)

hardcoded logic (tax, discount)

So if you want to change how something is done, you must modify this class.

That’s tight coupling.

🛠️ Maintainability (the consequence)

Because everything is tightly coupled:

If you want to:

save to a database instead of a file

send real emails instead of printing

change tax logic

change discount rules

👉 You must edit the same class in multiple places

That makes the system:

harder to update

more error-prone

harder to test

🎯 One-line distinction (exam-ready)

Tight coupling refers to strong dependencies between components, while poor maintainability is the result of those dependencies making the system difficult to modify or extend.

🔥 How to think about it

Tight coupling = design structure problem

Maintainability = real-world impact of that problem

🧪 Quick analogy

Think of it like this:

Tight coupling = everything is glued together

Maintainability = how hard it is to fix or replace parts

If everything is glued → it’s hard to fix → bad maintainability

✅ Should you keep both in your answer?

YES — they are different points.

But now you understand:

don’t treat them as identical

show the relationship if you want to sound advanced

If you want, I can help you slightly tweak your bullets so they connect these ideas cleanly without redundancy.

Isn;t how everything is glued together and specific parts pretty much the same thing

You’re very close—and this is where a lot of students get tripped up.

🔑 The subtle truth

They feel the same, but they are not the same concept.

Think of it like this:

Tight coupling = WHY things are glued together

Maintainability = WHAT happens because they are glued together

🧠 Let’s make it crystal clear
🔗 Tight Coupling (Design Property)

This is about how the code is written.

Example:

FileWriter writer = new FileWriter("orders.txt", true);

This means:

the class is directly tied to file storage

it cannot easily switch to a database, API, etc.

👉 That dependency = tight coupling

🛠️ Maintainability (Outcome / Impact)

Now because of that coupling:

If you want to:

switch to a database

change logging

modify email behavior

👉 you must go inside this same class and change multiple things

That makes the system:

harder to update

easier to break

harder to scale

👉 That = poor maintainability

🎯 The key difference (best way to say it)

Tight coupling is a design issue where components depend heavily on specific implementations, while maintainability refers to how easily the system can be modified as a result of that design.

🔥 Analogy (the best one)

Tight coupling = everything is wired directly together

Can you make the difference more clear and regerarate the evaulation.md

Absolutely—let’s make the distinction very explicit in your write-up so it doesn’t sound redundant.

✅ Final evaluation.md (Clear distinction included)
The `OrderProcessor` class demonstrates several object-oriented design issues that negatively impact its structure, maintainability, and extensibility. By combining multiple responsibilities into a single class and exposing its internal data, the design violates key object-oriented principles such as encapsulation and proper responsibility distribution. The main issues are outlined below:

- **Poor Encapsulation**: The class exposes its internal data (`customerName`, `email`, `item`, `price`) as public fields. This allows external code to directly modify the object's state, violating data hiding principles. A better design would make these fields private and provide controlled access through methods.

- **Too Many Responsibilities (Low Cohesion)**: The `processOrder()` method performs multiple unrelated tasks, including calculating tax, printing a receipt, saving data to a file, sending a confirmation email, applying a discount, and logging activity. This violates the idea that a class should represent one key abstraction and have a focused responsibility.

- **God Class / Centralized Control**: The `OrderProcessor` acts as a central controller that handles the entire workflow instead of delegating responsibilities to other classes. This leads to poor distribution of responsibilities and reduces flexibility in the design.

- **Tight Coupling to Implementation Details**: The class is directly dependent on specific implementations such as `FileWriter`, console output, and `Date`. This means the class is strongly tied to *how* tasks are performed (file storage, console logging, etc.), rather than relying on abstractions. As a result, changing one of these implementations (e.g., saving to a database instead of a file) requires modifying this class.

- **Poor Maintainability and Extensibility**: Because the class is tightly coupled and handles many responsibilities, any change to tax rules, discount policies, file storage, receipt formatting, email delivery, or logging requires modifying the same class. This increases the likelihood of introducing bugs and makes the system harder to extend over time.

- **Incorrect Workflow / Logic Issue**: The discount is applied after the receipt is printed and the order is saved, which can result in inconsistent or incorrect outputs.

In conclusion, the `OrderProcessor` class violates several core object-oriented design principles, including encapsulation, low coupling, and proper responsibility distribution. The tight coupling in the design leads directly to poor maintainability, and refactoring the system into smaller, focused classes would result in a more flexible and extensible design.
🔥 What changed (important)

Now the difference is crystal clear:

Tight Coupling bullet = explains the dependency problem

Maintainability bullet = explains the consequences of that problem

And the conclusion reinforces the relationship:

“The tight coupling in the design leads directly to poor maintainability”

🎯 Why this matters for grading

Now your answer shows:

you understand cause vs effect

you are not repeating yourself

you can connect OO principles together

That’s what separates a good answer from an A answer.

If you’re ready, let’s move to Part 2 (CRC redesign)—that’s where you can really show design mastery.

Ok lets move to the second part. I feel like I said this part a little eariler what are your thoughts on this statement in regards to teh second part "There is too much happening in one function processOrder it's calculating the tax, printing the reciept, saves it to a new file, sneds a confrimamation email, applies a discount, and logs acivity. This function isn't bad code wize but in regards to OOP this is simply not how it should look like. There should be multiple objects happening in this code there maybe an object that handles money relation where there is a getter/setter for the tax and discount as in the real world those are subject to change. There should be one that holds the customer's information(as well as maybe past orders). There should be an obkect htat handles the filewritting."

That statement is actually a good bridge into Part 2 because it already identifies the main redesign idea: split the responsibilities into separate objects.

What I’d change is the wording and one design detail.

Your instinct is correct that there should be:

an object for order/customer data

an object for money-related calculations

an object for persistence/file writing

probably an object for notifications

probably an object for logging

The one thing I would be careful about is saying “getter/setter for the tax and discount.” For CRC cards, it is usually stronger to frame those as responsibilities, not just getters and setters. So instead of saying “an object with getters/setters for tax and discount,” say something like:

a class that calculates tax

a class that applies discount rules

That sounds much more object-oriented and matches CRC thinking better.

So for Part 2, your idea could be translated like this:

Order or CustomerOrder stores customer/order information

PricingService or OrderCalculator calculates tax and total

DiscountPolicy applies discount rules

OrderRepository saves order data

NotificationService sends confirmation emails

ActivityLogger logs processing activity

OrderProcessor coordinates these collaborators instead of doing everything itself

That is the heart of the redesign.

A polished version of your thought would be:

The current design places too many responsibilities inside processOrder(), so the improved design should distribute those responsibilities across multiple collaborating objects. One class should store order and customer information, another should handle pricing concerns such as tax and discounts, another should manage persistence such as file writing, and additional classes can handle notifications and logging. This would produce a more object-oriented design with better responsibility distribution and lower coupling.

For CRC cards, though, we should now turn that into a clean list of classes, responsibilities, and collaborators.

A solid set for design.md would be:

Option I recommend

Order

OrderProcessor

PricingService

DiscountPolicy

OrderRepository

NotificationService

ActivityLogger

This is clean, realistic, and easy to explain.

If you want, next I’ll draft the actual design.md in CRC-card format exactly as you can paste it in.

Lets go with OrderCalculator, I feel like PricingService is a little vague. Other than that you can genrate design.md
Class: Order
Responsibilities:
- Store order information such as customer name, email, item, and price
- Provide access to order data needed during processing
Collaborators:
- OrderProcessor
- OrderCalculator
- OrderRepository
- NotificationService

Class: OrderProcessor
Responsibilities:
- Coordinate the overall order-processing workflow
- Use other classes to calculate totals, save orders, send notifications, and log activity
Collaborators:
- Order
- OrderCalculator
- OrderRepository
- NotificationService
- ActivityLogger

Class: OrderCalculator
Responsibilities:
- Calculate tax for an order
- Apply discount rules when appropriate
- Compute the final total for an order
Collaborators:
- Order

Class: OrderRepository
Responsibilities:
- Save order information to persistent storage
- Isolate file-writing or database-related logic from the rest of the system
Collaborators:
- Order
- OrderProcessor

Class: NotificationService
Responsibilities:
- Send confirmation messages to the customer
- Handle notification-related behavior separately from order processing
Collaborators:
- Order
- OrderProcessor

Class: ActivityLogger
Responsibilities:
- Record when order-processing activity occurs
- Isolate logging behavior from business logic
Collaborators:
- OrderProcessor

This is clean and strong for CRC format.

A couple notes on why this version works:

Order is the data-focused object

OrderCalculator handles money logic

OrderRepository handles saving

NotificationService handles email/confirmation

ActivityLogger handles logging

OrderProcessor coordinates instead of doing everything itself

That is a much better OO distribution than the original single-class design.

One small optional refinement: you could rename NotificationService to EmailService if you want to be more specific to the given code, but NotificationService is usually a little more extensible and design-friendly.

Similar to Task from Question1 why does Order need other collaborators 

Excellent catch — this is a very important distinction, and you’re thinking exactly like your professor wants.

🔑 Short Answer

👉 Order should NOT have collaborators (just like Task)

🧠 Why

Think back to Question 1:

Task = data + simple behavior

It does NOT depend on anything else

Same idea applies here:

Order

Its responsibilities are:

store data (customerName, email, item, price)

provide access to that data

👉 It does NOT:

calculate tax

save itself

send emails

log activity

So it should be independent

⚠️ What was wrong in the previous version

I listed:

Collaborators:
- OrderProcessor
- OrderCalculator
- OrderRepository
- NotificationService

That is not ideal OO design

Why?

Because that would imply:

Order depends on those classes

But in good OO design:

Order is just a data model — other classes depend on it

✅ Correct mental model
Direction of dependency

OrderProcessor → uses Order

OrderCalculator → uses Order

OrderRepository → uses Order

NotificationService → uses Order

But:

Order → uses no one

✅ Corrected CRC card for Order
Class: Order
Responsibilities:
- Store order information such as customer name, email, item, and price
- Provide access to order data
Collaborators:
- none
🧠 Why this matters (this is testable knowledge)

This ties directly to your slides:

Encapsulation → data is self-contained

Low coupling → Order doesn’t depend on other classes

Good responsibility distribution → Order = data, others = behavior

🔥 High-level insight (professor-level)

You just identified:

"Data model classes should not depend on service/processing classes"

That’s a very strong design principle

🎯 Final takeaway
Class Type	Should it have collaborators?
Data class (Task, Order)	❌ No
Manager / Service class	✅ Yes

If you want, I can now:

fix the entire design.md with this correction applied

or walk you through how to explain this on an exam verbally

please regen design.md with the corrects 
Class: Order
Responsibilities:
- Store order information such as customer name, email, item, and price
- Provide access to order data
Collaborators:
- none

Class: OrderProcessor
Responsibilities:
- Coordinate the overall order-processing workflow
- Use other classes to calculate totals, save orders, send notifications, and log activity
Collaborators:
- Order
- OrderCalculator
- OrderRepository
- NotificationService
- ActivityLogger

Class: OrderCalculator
Responsibilities:
- Calculate tax for an order
- Apply discount rules when appropriate
- Compute the final total for an order
Collaborators:
- Order

Class: OrderRepository
Responsibilities:
- Save order information to persistent storage
- Isolate file-writing or database-related logic from the rest of the system
Collaborators:
- Order

Class: NotificationService
Responsibilities:
- Send confirmation messages to the customer
- Handle notification-related behavior separately from order processing
Collaborators:
- Order

Class: ActivityLogger
Responsibilities:
- Record when order-processing activity occurs
- Isolate logging behavior from business logic
Collaborators:
- OrderProcessor

This version is much cleaner conceptually because:

Order is independent, like Task

service/processing classes depend on Order, not the other way around

OrderProcessor coordinates instead of doing all the work itself

One small thought: if you want to be even more specific, ActivityLogger could also list Order as a collaborator if you imagine it logging order-specific details, but as written now, this is still solid and consistent.

Why would ActivityLogger collaborate with order when  it's job is to soley log?

Great question — this is exactly the level of precision that gets full credit.

🔑 Short Answer

👉 ActivityLogger does NOT need to collaborate with Order unless it logs order-specific data.

🧠 Think in terms of responsibilities (CRC mindset)
What is ActivityLogger responsible for?

From your design:

“Record when order-processing activity occurs”

“Isolate logging behavior”

That means its job is:

👉 logging events, not understanding orders

🧩 When WOULD it collaborate with Order?

Only if its responsibility changes to something like:

“Log order details”

“Record order-specific information (customer, item, total)”

Then it would need access to:

order.getCustomerName()
order.getItem()

👉 In that case:

ActivityLogger → Order
⚠️ But in YOUR current design

You defined it as:

“Record when order-processing activity occurs”

That implies something like:

log("Order processed at time X");

👉 That does NOT require Order

✅ So your instinct is correct

“its job is to solely log”

✔️ Correct
✔️ No need for Order
✔️ Keeps coupling low (which is GOOD design)

🎯 Correct CRC for ActivityLogger
Class: ActivityLogger
Responsibilities:
- Record when order-processing activity occurs
- Isolate logging behavior from business logic
Collaborators:
- OrderProcessor
🔥 Key design principle you just used

You avoided unnecessary coupling

From your slides:

Only collaborate when needed to fulfill a responsibility

🧠 Advanced insight (this is A-level thinking)

You’re distinguishing between:

logging events (no Order needed)

logging data (Order needed)

That’s a subtle but powerful design decision.

🚀 Final takeaway
Scenario	Should ActivityLogger use Order?
Just logging events	❌ No
Logging order details	✅ Yes

If you want, I can now help you do a final polish pass on design.md to make sure it’s exactly submission-ready.

Please do

Perfect—here’s your final, submission-ready design.md with everything clean, consistent, and aligned with CRC principles.

✅ Final design.md
Class: Order
Responsibilities:
- Store order information such as customer name, email, item, and price
- Provide access to order data
Collaborators:
- none

Class: OrderProcessor
Responsibilities:
- Coordinate the overall order-processing workflow
- Delegate tasks such as calculation, persistence, notification, and logging to appropriate classes
Collaborators:
- Order
- OrderCalculator
- OrderRepository
- NotificationService
- ActivityLogger

Class: OrderCalculator
Responsibilities:
- Calculate tax for an order
- Apply discount rules when appropriate
- Compute the final total for an order
Collaborators:
- Order

Class: OrderRepository
Responsibilities:
- Save order information to persistent storage
- Isolate file-writing or database-related logic from the rest of the system
Collaborators:
- Order

Class: NotificationService
Responsibilities:
- Send confirmation messages to the customer
- Handle notification-related behavior separately from order processing
Collaborators:
- Order

Class: ActivityLogger
Responsibilities:
- Record when order-processing activity occurs
- Isolate logging behavior from business logic
Collaborators:
- OrderProcessor
🔥 Why this is strong (quick sanity check)

Order has no collaborators ✔️ (correct data model design)

Responsibilities are clearly separated ✔️

No “god class” anymore ✔️

Uses delegation and collaboration properly ✔️

Matches CRC format exactly ✔️

Clean, readable, and professor-friendly ✔️

🎯 You’re done with Part 2

This will score well because it shows:

understanding of responsibility distribution

understanding of low coupling

understanding of object roles