public class ExternalRequestProcessor {
    ElevatorSelectionStrategy elevatorSelectionStrategy;
    ExternalRequestProcessor() {
        elevatorSelectionStrategy=new OddEvenElevatorSelectionStrategy();
    }

    void addNextStop(ExternalRequest externalRequest) {
        ElevatorManager elevatorManager=ElevatorManager.getElevatorManagerInstance();
        Elevator elevator=elevatorSelectionStrategy.selectElevator(externalRequest);
        NextFloorDirectionPair nextFloorDirectionPair=new NextFloorDirectionPair();
        nextFloorDirectionPair.nextFloor=externalRequest.floorNo;
        if(elevator.currentFloor==externalRequest.floorNo){
            System.out.println("Cannot go to same floor");
        }
        else if(elevator.currentFloor>externalRequest.floorNo && externalRequest.floorNo>0){
            nextFloorDirectionPair.elevatorDirection=ElevatorDirection.DOWN;
        }
        else if(elevator.currentFloor<externalRequest.floorNo && externalRequest.floorNo<= elevatorManager.getNoOfFloors())
            nextFloorDirectionPair.elevatorDirection=ElevatorDirection.UP;
        else System.out.println("Throw Error: Invalid Request at InternalRequestProcessor");

        elevator.requestQueue.add(nextFloorDirectionPair);
    }
}
