# Elevator System Simulation

This is a Java-based simulation of an elevator system designed to handle multiple elevators with various request handling strategies. The system supports both internal and external requests, prioritizing floors and directions based on configured strategies.

## Features

- **Multiple Elevators**: Supports a configurable number of elevators and floors.
- **Internal and External Requests**: Handles requests originating both inside and outside the elevator.
- **Request Strategies**: Supports different strategies for moving elevators (e.g., First-Come-First-Serve) and selecting elevators (e.g., Odd/Even floor-based selection).
- **Single Floor Requests Prevention**: Prevents redundant requests for the same floor.
- **Error Handling**: Validates floor requests to ensure they are within the building range.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (optional but recommended) such as IntelliJ IDEA, Eclipse, or Visual Studio Code

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/premtsd18/ElevatorLLD
   cd ElevatorLLD
   ```

2. **Compile the Code**:
   If you’re running this from the command line, navigate to the project directory and run:
   ```bash
   javac *.java
   ```

3. **Run the Simulation**:
   ```bash
   java ElevatorDemo
   ```

### Project Structure

The project is organized into several classes, each responsible for a part of the elevator system logic:

- **`Elevator.java`**: Represents an individual elevator, maintaining its state and request queue. Manages movement between floors.
- **`ElevatorController.java`**: Controls the movement of a single elevator, determining the next floor based on a strategy.
- **`ElevatorManager.java`**: Manages all elevators, processes incoming requests, and initializes the elevator system.
- **`ElevatorSystem.java`**: Provides a singleton instance for managing the system, allowing centralized control of requests and processing.
- **`InternalRequestProcessor.java` and `ExternalRequestProcessor.java`**: Handle internal and external requests, routing them to the appropriate elevator.
- **Request Classes (`InternalRequest.java`, `ExternalRequest.java`)**: Represent requests made within and outside of elevators.
- **Strategy Interfaces (`ElevatorMovingStrategy.java`, `ElevatorSelectionStrategy.java`)**: Define the behavior for elevator movement and selection.
- **Strategy Implementations (`FCFSElevatorMovingStrategy.java`, `OddEvenElevatorSelectionStrategy.java`)**: Implement specific movement and selection strategies.
- **Utility Classes**:
    - `NextFloorDirectionPair.java`: Helper class for storing floor and direction pairs.
    - `ElevatorDirection.java`: Enum representing elevator direction states (UP, DOWN, IDLE).

## Usage Example

Below is an example usage of the elevator system in `ElevatorDemo.java`:

```java
public class ElevatorDemo {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();
        elevatorSystem.initializeTheElevators(10, 2);

        // Add some requests
        elevatorSystem.sendExternalRequest(new ExternalRequest(5, ElevatorDirection.UP));
        elevatorSystem.sendInternalRequest(new InternalRequest(1, 4));
        elevatorSystem.sendInternalRequest(new InternalRequest(2, 7));

        // Process requests over a few cycles
        for (int counter = 0; counter < 5; counter++) {
            System.out.println("----------------------------------------------------------");
            elevatorSystem.processRequest();
        }
    }
}
```

This script initializes the elevator system with 10 floors and 2 elevators. It then sends both external and internal requests and processes them in multiple cycles.

## Classes and Components

| Class                         | Description                                                                                     |
|-------------------------------|-------------------------------------------------------------------------------------------------|
| `Elevator`                    | Manages individual elevator attributes and movement.                                           |
| `ElevatorController`          | Controls an elevator, determining the next stop based on a strategy.                           |
| `ElevatorManager`             | Initializes and manages all elevators, routing requests to the appropriate elevators.          |
| `ElevatorSystem`              | Singleton class managing centralized elevator control.                                         |
| `ExternalRequestProcessor`    | Routes external requests to the correct elevator.                                              |
| `InternalRequestProcessor`    | Handles requests made from inside an elevator.                                                 |
| `FCFSElevatorMovingStrategy`  | Implements First-Come-First-Serve movement strategy.                                           |
| `OddEvenElevatorSelectionStrategy` | Chooses an elevator based on the odd/even floor rule.                                       |
| `ExternalRequest` / `InternalRequest` | Represent external/internal requests for elevator service.                             |
| `NextFloorDirectionPair`      | Utility class storing floor and direction information for requests.                           |
| `ElevatorDirection`           | Enum representing the directions an elevator can move (UP, DOWN, IDLE).                       |

## Design Decisions

- **Strategy Pattern**: To allow flexibility in choosing different movement and selection strategies for elevators.
- **Singleton Pattern**: `ElevatorSystem` is implemented as a singleton for centralized control and management.
- **Error Handling**: Requests are validated to ensure that floor numbers are within the allowable range and to avoid redundant requests to the same floor.
