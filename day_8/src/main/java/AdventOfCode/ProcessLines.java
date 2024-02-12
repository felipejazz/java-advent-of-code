package AdventOfCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessLines {


    private Direction directions;
    private List<Coordinate> coordinates;

    public void setDirections(Direction directions) {
        this.directions = directions;
    }

    public Direction getDirections() {
        return directions;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void run(List<String> lines) {

        List<Direction> playersList = new ArrayList<>();
        boolean parsedDirections = false;
        List<String> directionsList = new ArrayList<>();
        List<String> coordinatesList= new ArrayList<>();
        List<Coordinate> parsedCoordinates = new ArrayList<>();
        Direction directions = new Direction();
        Map<Direction, List<Coordinate>> input = new HashMap<>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (!parsedDirections) {
                if (!line.isEmpty()) {
                    directionsList.add(line);
                } else {
                    parsedDirections = true;
                }
            } else {
                coordinatesList.add(line);
            }
        }

        Pattern coordinatesPattern = Pattern.compile("(\\w+)\\s*=\\s*\\((\\w+),\\s*(\\w+)\\)");
        for (String coordinate: coordinatesList) {
            Matcher coordinatesMatcher = coordinatesPattern.matcher(coordinate);
            while ( coordinatesMatcher.find()) {

                String coord = coordinatesMatcher.group(1);
                String left = coordinatesMatcher.group(2);
                String right = coordinatesMatcher.group(3);
                Coordinate coordinateTemp = new Coordinate(coord, left, right);
                parsedCoordinates.add(coordinateTemp);

            }
        }
        directions.setDirections(directionsList);
        setDirections(directions);
        setCoordinates(parsedCoordinates);
    }
}

