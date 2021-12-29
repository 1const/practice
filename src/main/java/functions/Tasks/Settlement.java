package functions.Tasks;

public class Settlement extends Location {

    private int settlement;
    private SetElementType type;

    public void setSettlement(int settlement) {
        this.settlement = settlement;
    }

    public int getSettlement() {
        return settlement;
    }

    public void setType(SetElementType type) {
        this.type = type;
    }

    public SetElementType getType() {
        return type;
    }
}