package functions.Tasks;

public class Waypoint extends Location {

    private WaypointType type;
    private Settlement settlement;

    public void setType(WaypointType type) {
        this.type = type;
    }

    public WaypointType getType() {
        return type;
    }

    public void setSettlement(Settlement settlement) {
        this.settlement = settlement;
    }

    public Settlement getSettlement() {
        return settlement;
    }
}
