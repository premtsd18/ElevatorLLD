public class InternalRequestProcessor {
    void addNextStop(InternalRequest internalRequest) {
        ElevatorManager elevatorManager=ElevatorManager.getElevatorManagerInstance();
        Elevator elevator=elevatorManager.elevatorHashMap.get(internalRequest.getElevatorID());
        NextFloorDirectionPair nextFloorDirectionPair=new NextFloorDirectionPair();
        nextFloorDirectionPair.nextFloor=internalRequest.floorNo;
        if(elevator.currentFloor==internalRequest.floorNo){
            System.out.println("Cannot go to same floor");
        }
        else if(elevator.currentFloor>internalRequest.floorNo && internalRequest.floorNo>0){
            nextFloorDirectionPair.elevatorDirection=ElevatorDirection.DOWN;
        }
        else if(elevator.currentFloor<internalRequest.floorNo && internalRequest.floorNo<= elevatorManager.getNoOfFloors())
            nextFloorDirectionPair.elevatorDirection=ElevatorDirection.UP;
        else System.out.println("Throw Error: Invalid Request at InternalRequestProcessor");

        elevator.requestQueue.add(nextFloorDirectionPair);
    }
}
