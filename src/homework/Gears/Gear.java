package homework.Gears;

import java.util.ArrayList;
import java.util.List;

public final class Gear {
    private final List<Gear> neighbors = new ArrayList<>();
    private Boolean direction = null;


    public List<Gear> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Gear gear) {
        neighbors.add(gear);
    }

    public boolean hasDirection() {
        return direction != null;
    }

    public Boolean getDirection() {
        return direction;
    }

    public void setDirection(Boolean value) {
        direction = value;
    }
}
