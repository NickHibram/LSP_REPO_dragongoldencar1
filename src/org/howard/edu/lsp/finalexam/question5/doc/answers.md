Heuristic 1:
Name:
H2.1: All data should be hidden within its class. (Slide 7 of Object-Oriented_Heuristics Lecture)

Explanation:
This improves readability and maintainability because it enforces encapsulation, meaning other classes cannot directly access or modify internal data. In lecture, this was explained as keeping data private and only interacting through public methods. This makes it easier to change the internal implementation of a class without breaking other parts of the system.

Heuristic 2:
Name:
H3.2: Do not create god classes/objects in your system. (Slide 10 of Object-Oriented_Heuristics Lecture)

Explanation:
This improves maintainability by preventing one class from controlling too much of the system. In lecture, the “HeatFlowRegulator” example showed a god class that handled all logic instead of letting other classes make decisions. Breaking responsibilities across multiple classes makes the system easier to modify and reduces dependency on one large, complex class.

Heuristic 3:
Name:
H2.8: A class should capture one and only one key abstraction. (Slide 7 of Object-Oriented_Heuristics Lecture)

Explanation:
This improves readability because each class has a clear and focused purpose. In lecture, this was described as avoiding classes that mix multiple responsibilities. When a class focuses on one abstraction, it is easier to understand, test, and modify without affecting unrelated functionality.