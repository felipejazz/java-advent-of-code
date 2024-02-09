package AdventOfCode;

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

import AdventOfCode.ProcessInput;
import AdventOfCode.ProcessLines;


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
            long result = processLines.run(lineGames);
            System.out.println(result);
            assertThat(result, equalTo(35L));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("File not found: " + input);
        } catch (IOException e) {
            e.printStackTrace();
            fail("I/O error: " + input);
        }

        
    }
}
