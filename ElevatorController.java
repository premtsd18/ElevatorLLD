public class ElevatorController {
    ElevatorMovingStrategy elevatorMovingStrategy;
    ElevatorController(){
        elevatorMovingStrategy=new FCFSElevatorMovingStrategy();
    }

    int determineNextStop(Elevator elevator){
        return elevatorMovingStrategy.nextFloor(elevator);
    }

    void moveElevator(Elevator elevator){
        int nextStop=determineNextStop(elevator);
        if(nextStop!=-1){
            System.out.println("Moving from "+elevator.currentFloor+" to "+nextStop);
            elevator.currentFloor=nextStop;
        }
    }
}
