import java.util.HashMap;

public class ElevatorManager {
    int noOfFloors;
    int noOfElevators;
    static ElevatorManager elevatorManagerInstance;
    HashMap<Integer,Elevator> elevatorHashMap;



    private ElevatorManager(){

    }

    public static ElevatorManager setupElevators(int noOfFloors, int noOfElevators){
        if(elevatorManagerInstance == null){elevatorManagerInstance = new ElevatorManager();}
        elevatorManagerInstance.setNoOfFloors(noOfFloors);
        elevatorManagerInstance.setNoOfElevators(noOfElevators);
        elevatorManagerInstance.elevatorHashMap=new HashMap<>();
        for(int elevatorIdx=1;elevatorIdx<=noOfElevators;elevatorIdx++){
            elevatorManagerInstance.elevatorHashMap.put(elevatorIdx,new Elevator());
        }

        return elevatorManagerInstance;
    }

    public void setNoOfElevators(int noOfElevators){this.noOfElevators = noOfElevators;}
    public void setNoOfFloors(int noOfFloors){this.noOfFloors = noOfFloors;}
    public int getNoOfFloors(){return noOfFloors;}

    public static ElevatorManager getElevatorManagerInstance(){
        if(elevatorManagerInstance == null){
            System.out.println("Error: Setup the Elevator Manager instance"); // Throw Exception
        }
        return elevatorManagerInstance;
    }


}
