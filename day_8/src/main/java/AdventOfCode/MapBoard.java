package AdventOfCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapBoard {

    private Map<String, Coordinate> coordinates;
    private Direction directions;

    public MapBoard(Map<String, Coordinate> coordinates, Direction directions){
        this.coordinates = coordinates;
        this.directions = directions;
    }

    Map<String, String> getDestinations(String actualPosition) {
        if (this.coordinates.containsKey(actualPosition)) {
            Coordinate pos = this.coordinates.get(actualPosition);
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("L", pos.getLeftDestination());
            resultMap.put("R", pos.getRightDestination());
            return resultMap;
        }
        return null;
    }

    public int calculateSteps() {
        List<String> directions = this.directions.getDirections();
        String actualPosition = "AAA";
        Map<String, String> actualDestinations = getDestinations(actualPosition);
        int steps = 0;
        System.out.println(actualDestinations);
        while (!actualPosition.equals("ZZZ")) {
            for (String direction: directions) {

                for (int i = 0; i < direction.length(); i++) {

                    if (actualPosition.equals("ZZZ")){
                        break;
                    }

                    char actualDir = direction.charAt(i);
                    System.out.println(actualDir);
                    String coordinate = String.valueOf(actualDir);
                    System.out.println("Step: " + steps + " Actual Position: " + actualPosition + " Coordinate: " + coordinate);
                    steps++;
                    actualPosition = actualDestinations.get(coordinate);

                    System.out.println("Destination: " + actualPosition);
                    actualDestinations = getDestinations(actualPosition);
                }
                if (actualPosition.equals("ZZZ")) {
                    break;
                }
            }
        }
        System.out.println("Total Steps: " + steps);
        return steps;
    };


    public void setCoordinates(Map<String, Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Map<String, Coordinate> getCoordinates() {
        return this.coordinates;
    }

    public Direction getDirections() {
        return directions;
    }

    public void setDirections(Direction directions) {
        this.directions = directions;
    }

    public void processCoordinates(){

    }

    public void find(Direction directions) {
        List<String> directionsString = directions.getDirections();
        for (String direction: directionsString){
            System.out.println(direction);
        }
//        Coordinate actualCoordinate = new Coordinate();
//        actualCoordinate.setActualPosition(di);
//        for (int i = 0; i < directionsString.length(); i++) {
//
//        }


    }


}
