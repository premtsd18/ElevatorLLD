public class ExternalRequest {
    int floorNo;
    ElevatorDirection direction;
    public ExternalRequest(int floorNo, ElevatorDirection direction) {
        this.floorNo = floorNo;
        this.direction = direction;
    }
    public int getFloorNo() {return floorNo;}
    public ElevatorDirection getDirection() {return direction;}
}
