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