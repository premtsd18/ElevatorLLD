public class InternalRequest {
    int elevatorID;
    int floorNo;
    public InternalRequest(int elevatorID, int floorNo) {
        this.floorNo = floorNo;
        this.elevatorID = elevatorID;
    }
    public int getFloorNo() {return floorNo;}
    public int getElevatorID() {return elevatorID;}
}
