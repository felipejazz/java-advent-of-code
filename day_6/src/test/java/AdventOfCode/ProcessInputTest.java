package AdventOfCode;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProcessInputTest {
    ProcessInput processInput = new ProcessInput();
    ProcessLines processLines = new ProcessLines();


    @Test
    public void exampleInput() {
        String input = "./test/input.txt";
        List<String> lineGames;

        try {

            lineGames = processInput.run(input);
            int result = processLines.run(lineGames);
            System.out.println(result);
            assertThat(result, equalTo(288));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("File not found: " + input);
        } catch (IOException e) {
            e.printStackTrace();
            fail("I/O error: " + input);
        }


    }
}
