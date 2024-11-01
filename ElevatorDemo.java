public class ElevatorDemo {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem=ElevatorSystem.getInstance();
        elevatorSystem.initializeTheElevators(10,2);
        ElevatorManager elevatorManager=ElevatorManager.getElevatorManagerInstance();
        elevatorSystem.sendExteralRequest(new ExternalRequest(5,ElevatorDirection.UP));
        elevatorSystem.sendExteralRequest(new ExternalRequest(2,ElevatorDirection.UP));
        elevatorSystem.sendInternalRequest(new InternalRequest(1,4));
        elevatorSystem.sendInternalRequest(new InternalRequest(2,7));
        elevatorSystem.sendInternalRequest(new InternalRequest(1,5));
        for(int counter=0;counter<5;counter++){
            System.out.println("----------------------------------------------------------");
            elevatorSystem.processRequest();
        }
        elevatorSystem.sendExteralRequest(new ExternalRequest(5,ElevatorDirection.UP)); // Moving from same floor to same floor
        elevatorSystem.sendInternalRequest(new InternalRequest(1,-1)); // Moving to Negative floor
        elevatorSystem.sendInternalRequest(new InternalRequest(1,20)); // Moving to Higher Positive floor
    }
}