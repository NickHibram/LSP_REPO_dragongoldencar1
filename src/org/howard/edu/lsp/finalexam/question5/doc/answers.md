Heuristic 1:
Name:
H2.1: All data should be hidden within its class. (Slide 7)

Explanation:
This improves readability and maintainability by enforcing encapsulation. In lecture, it was explained that each class should contain its own data and only expose a public interface. This allows the internal implementation of a class to change without affecting other classes, as long as the interface remains stable. This reduces the impact of changes and makes the system easier to maintain.

Heuristic 2:
Name:
H3.2: Do not create god classes/objects in your system. (Slide 10)

Explanation:
This improves maintainability by preventing too much centralization. In lecture, it was explained that if one class controls everything, it becomes a “god class” and takes on responsibilities that belong to other classes. The professor described this as a system where one class does all the thinking while the other classes are essentially “slaves” that just provide data. This reduces flexibility because most changes must be made in one large class instead of being distributed across smaller, more autonomous classes.

Heuristic 3:
Name:
H3.3: Beware of classes that have many accessor methods defined in their public interface. (Slide 10)

Explanation:
This improves maintainability by minimizing coupling between classes. In lecture, it was explained that if one class has many getters and setters, other classes may repeatedly pull data from it and perform similar operations. Instead, that behavior should be moved into the class itself. The Toast and Toaster example showed good distribution of behavior, where each class handles its own responsibilities rather than relying on another class to manipulate its data. This reduces dependencies and makes the system easier to modify.