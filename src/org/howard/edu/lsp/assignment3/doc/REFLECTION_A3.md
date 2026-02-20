# Comparison of Assignment 2 and Assignment 3

Assignment 2 and Assignment 3, while producing the same final result, are fundamentally different in structure. Assignment 2 follows a procedural design where all logic exists within a single `main()` method. Assignment 3, in contrast, restructures the same problem using object-oriented programming (OOP) principles by organizing the solution into separate classes with defined responsibilities. The following sections explain how the design differs and how the development process changed between the two implementations.

---

## What Exactly Is Different About the Design?

The goal of the program in both assignments is to take a CSV file and transform it into another CSV file. In Assignment 2, this was handled procedurally. The program opened the input file using a `BufferedReader`, read each line sequentially, and split the line into fields using `split(",")`. It validated the data by ensuring the correct number of columns and confirming that `ProductID` and `Price` were numeric values. If a row failed validation, it was skipped and counted.

For valid rows, the program directly applied the transformation logic:
- Converting the name to uppercase  
- Applying a 10% discount to Electronics  
- Rounding the price to two decimal places  
- Upgrading the category to Premium Electronics when appropriate  
- Determining the `PriceRange`

The transformed values were immediately written to the output file using a `BufferedWriter`, and summary statistics were printed at the end. In this design, all extraction, transformation, validation, and loading logic existed inside a single `main()` method.

Assignment 3 redesigned the solution using object-oriented principles by decomposing that single method into multiple classes, each with a distinct responsibility.

A `Product` class was introduced to serve as the framework for the data itself. It encapsulated the necessary CSV fields—`productId`, `name`, `price`, and `category`—along with a validity flag, giving each `Product` object its own state. Through encapsulation, all fields were made private and accessed through getters, setters, and utility methods, ensuring the data is controlled within the object rather than manipulated freely in `main()`.

The `ProductExtractor` class represents the extraction stage. Instead of parsing raw values directly in `main()`, it creates actual `Product` objects. It reads the CSV line by line, attempts to construct `Product` instances, and tracks totals and invalid records internally.

The `ProductTransformer` class applies transformation logic and demonstrates inheritance by extending the `Product` class. This means a `ProductTransformer` “is-a” `Product` but with additional behavior. It adds a new field, `priceRange`, and centralizes all transformation logic inside a public `transform()` method. That method internally calls private helper methods, reinforcing encapsulation by hiding implementation details. It also overrides `toCSVString()`, demonstrating polymorphism, since the same method behaves differently depending on whether the object is a `Product` or a `ProductTransformer`.

The `ProductLoader` class handles writing the transformed objects to the output file and tracking upload statistics, further separating responsibilities. Finally, the `ETLPipeline` class serves strictly as the entry point, orchestrating the Extract–Transform–Load stages by creating objects and passing them between classes.

Overall, Assignment 3 clearly applies objects, classes, encapsulation, inheritance, and polymorphism to separate concerns. Compared to Assignment 2’s single procedural method, this design is more modular, readable, maintainable, and aligned with real software engineering practices.

---

## How Did the Code Process Differ?

The process I took for Assignment 2 and Assignment 3 was very different. For Assignment 2, I thought about the overall goal and immediately began coding. Because the solution was procedural and contained inside a single `main()` method, I could build it step by step and adjust the logic as I went. The focus was mainly on making the code work correctly within one file.

Assignment 3 required a different mindset. Since object-oriented programming involves multiple classes and responsibilities, I knew I could not just start coding without a clear structure. Instead, I spent more time planning the design—deciding what each class would do, how data would flow between them, and how the Extract–Transform–Load stages would connect. Because we were allowed to use AI, much of this planning involved dialogue between me and my AI of choice, Claude. I used those conversations to refine the architecture and ensure it satisfied all assignment requirements before implementation.

In terms of coding, Assignment 2 felt more manual and iterative. I wrote the logic, tested it, and adjusted it within the same file. For Assignment 3, once the structure was clearly defined, the coding process was much more streamlined. Since the design had already been worked out, implementing the classes and methods was relatively efficient.

For testing and debugging, I followed a similar approach for both assignments. I tested edge cases such as:
- Missing input files  
- Malformed CSV data  
- Incorrect data types  
- Empty files  

I also compared outputs to ensure the transformation rules and summary statistics matched expectations.

Using AI as part of the development process was different from how I originally learned computer science, but it was valuable. Instead of relying on trial-and-error coding, I focused more on planning, system design, and architectural correctness before implementation. It felt less like coding alone and more like collaborating on a structured plan with my colleague, Claude. By refining the blueprint first and then executing it efficiently, Assignment 3 felt closer to a real-world software engineering process than a basic programming exercise.
