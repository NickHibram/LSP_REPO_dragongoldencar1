**Class: Aircraft**

Responsibilities:
- Stores specific aircraft data such as id, status, flight_number, location, etc. 

Collaborators:
- Transponder

Assumptions:
- None

******Class**:** Transponder**

Responsibilities:
- Broadcasts aircraft data from Aircraft to the ATCSystem
  
Collaborators:
- ATCSystem
- Aircraft

Assumptions:
- None

**Class: ATCSystem**

Responsibilities:
- Receives data from Transponder
-  Unpacks Transponder data
-  Sends data to the AircraftDatabase

Collaborators:
- Transponder
- AircraftDatabase

Assumptions:
- None

**Class: GraphicSystem**

Responsibilities:
- Accesses  AircraftDatabase and displays the data on the graphic display
- Refreshes and repeats the process every 10 seconds
  
Collaborators:
- AircraftDatabase

Assumptions:
- None

**Class: Controller**

Responsibilities:
- Queries AircraftDatabase for details on aircraft on the graphic display

Collaborators:
- GraphicSystem
- AircraftDatabase

Assumptions:
- None

**Class: AircraftDatabase**

Responsibilities:
- Receives data from ATCSystem and DangerDetector
- Stores aircraft data
- Allows access to data in a safe and encapsulated manner
  
Collaborators:
- ATCSystem
- Controller
- GraphicSystem
- DangerDetector

Assumptions:
- None

**Class: DangerDetector**

Responsibilities:
- Detects possible danger utilizing various aircraft’s data  
- Sends danger warnings to AircraftDatabase

Collaborators:
- AircraftDatabase

Assumptions:
- None

