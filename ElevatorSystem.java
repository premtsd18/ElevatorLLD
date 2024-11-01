public class ElevatorSystem {
    private ElevatorSystem() {}
    static ElevatorSystem elevatorSystemInstance ;
    InternalRequestProcessor internalRequestProcessor;
    ExternalRequestProcessor externalRequestProcessor;
    ElevatorManager elevatorManager;
    public static ElevatorSystem getInstance() {
        if(elevatorSystemInstance == null) {
            elevatorSystemInstance = new ElevatorSystem();
        elevatorSystemInstance.internalRequestProcessor = new InternalRequestProcessor();
        elevatorSystemInstance.externalRequestProcessor = new ExternalRequestProcessor();
        }
        return elevatorSystemInstance;
    }
    void initializeTheElevators(int noOfFloors,int noOfElevators) {
        ElevatorManager.setupElevators(noOfFloors,noOfElevators);
        elevatorManager=ElevatorManager.getElevatorManagerInstance();
    }

    public void sendInternalRequest(InternalRequest internalRequest){
        internalRequestProcessor.addNextStop(internalRequest);
    }

    public void sendExteralRequest(ExternalRequest externalRequest){
        externalRequestProcessor.addNextStop(externalRequest);
    }

    public void processRequest(){


        for(int elevatorID:elevatorManager.elevatorHashMap.keySet()){
            Elevator elevator = elevatorManager.elevatorHashMap.get(elevatorID);
            System.out.println("Elevator ID: "+elevatorID+" : ");
            elevator.elevatorController.moveElevator(elevator);
        }
    }
}
