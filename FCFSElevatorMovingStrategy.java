public class FCFSElevatorMovingStrategy implements ElevatorMovingStrategy{
    @Override
    public int nextFloor(Elevator elevator){
        if(elevator.requestQueue.size()>=1)
            return elevator.requestQueue.poll().nextFloor;
        return -1;
    }
}
