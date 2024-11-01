import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    ElevatorController elevatorController;
    float capacity;
    Queue<NextFloorDirectionPair> requestQueue;
    int currentFloor;
    boolean[] floorButtonChoosed; // cannot press the same button. Need to be implemented.
    Elevator() {
        capacity = Float.MAX_VALUE;
        elevatorController = new ElevatorController();
        requestQueue = new LinkedList<NextFloorDirectionPair>();
        currentFloor = 1;
    }
}
