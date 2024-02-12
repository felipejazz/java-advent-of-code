package AdventOfCode;

import java.util.HashMap;
import java.util.Map;

public class Coordinate {

    public String actualPosition;
    public String leftDestination;
    public String rightDestination;

    public Coordinate(String actualPosition, String leftDestination, String rightDestination) {
        this.actualPosition = actualPosition;
        this.leftDestination = leftDestination;
        this.rightDestination = rightDestination;
    }

    public void setActualPosition(String actualPosition) {
        this.actualPosition = actualPosition;
    }

    public String getActualPosition() {
        return actualPosition;
    }

    public void setLeftDestination(String leftDestination) {
        this.leftDestination = leftDestination;
    }

    public String getLeftDestination() {
        return leftDestination;
    }

    public void setRightDestination(String rightDestination) {
        this.rightDestination = rightDestination;
    }

    public String getRightDestination() {
        return rightDestination;
    }

}

