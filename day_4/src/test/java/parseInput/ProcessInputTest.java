package parseInput;

import java.beans.Transient;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class ProcessInputTest {
    ProcessInput processInput = new ProcessInput();
    ProcessLines processLines = new ProcessLines();
    int result;


    @Test
    public void exampleInput() {
        String input = "/home/felipe-tarvos/repos/java_aoc/day_3/src/test/input.txt";


        try {
        
            List<String> lineGames = processInput.run(input);    
            result = processLines.run(lineGames);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("File not found: " + input);
        } catch (IOException e) {
            e.printStackTrace();
            fail("I/O error: " + input);
        }

        assertThat(result, equalTo(4361));
    }
}
