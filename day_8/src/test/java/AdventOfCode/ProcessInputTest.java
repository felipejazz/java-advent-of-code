package AdventOfCode;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProcessInputTest {
    ProcessInput processInput = new ProcessInput();
    ProcessLines processLines = new ProcessLines();
    List<String> lineGames;


    @Test
    public void exampleInput() {
        String input = "./test/input.txt";
        List<String> lineGames;

        try {

            lineGames = processInput.run(input);
            processLines.run(lineGames);
            Direction directions = processLines.getDirections();
            List<Coordinate> coordinatesList = processLines.getCoordinates();
            Map<String, Coordinate> coordinates = new HashMap<>();
            for (Coordinate coordinate: coordinatesList){
                coordinates.put(coordinate.actualPosition, coordinate);
            }
            MapBoard mapBoard = new MapBoard(coordinates, directions);
            int result = mapBoard.calculateSteps();

            assertThat(result, equalTo(6));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("File not found: " + input);
        } catch (IOException e) {
            e.printStackTrace();
            fail("I/O error: " + input);
        }


    }
}
