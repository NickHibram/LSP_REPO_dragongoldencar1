**Class: Aircraft**

Responsibilities:
- Stores specific aircraft data such as id, status, flight_number, location, etc. 

Collaborators (if any):
- Transponder


******Class**:** Transponder**

Responsibilities:
- Broadcasts aircraft data from Aircraft to the ATCSystem
  
Collaborators (if any):
- ATCSystem
- Aircraft 

**Class: ATCSystem**

Responsibilities:
- Receives data from Transponder
-  Unpacks Transponder data
-  Sends data to the AircraftDatabase

Collaborators (if any):
- Transponder
- AircraftDatabase


**Class: GraphicSystem**

Responsibilities:
- Accesses  AircraftDatabase and displays the data on the graphic display
- Refreshes and repeats the process every 10 seconds
  
Collaborators (if any):
- AircraftDatabase



**Class: Controller**

Responsibilities:
- Queries AircraftDatabase for details on aircraft on the graphic display

Collaborators (if any):
- GraphicSystem
- AircraftDatabase


**Class: AircraftDatabase**

Responsibilities:
- Receives data from ATCSystem and DangerDetector
- Stores aircraft data and allows access in a safe and encapsulated manner
  
Collaborators (if any):
- ATCSystem
- Controller
- GraphicSystem
- DangerDetector



**Class: DangerDetector**

Responsibilities:
- Detects possible danger utilizing various aircraft’s data  
- Sends danger warnings to AircraftDatabase

Collaborators (if any):
- AircraftDatabase



