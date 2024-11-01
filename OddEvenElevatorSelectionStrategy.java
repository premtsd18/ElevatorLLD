public class OddEvenElevatorSelectionStrategy implements ElevatorSelectionStrategy {
    @Override
    public Elevator selectElevator(ExternalRequest externalRequest){
        ElevatorManager elevatorManager=ElevatorManager.getElevatorManagerInstance();
        if(externalRequest.getFloorNo()%2==0){
            return elevatorManager.elevatorHashMap.get(2);
        }
        return elevatorManager.elevatorHashMap.get(1);
    }
}