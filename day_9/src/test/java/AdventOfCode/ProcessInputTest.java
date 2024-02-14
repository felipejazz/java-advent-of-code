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

    @Test
    public void exampleInput() {
        ProcessInput processInput = new ProcessInput();
        List<String> lineGames;
        String input = "./test/input.txt";

        try {

            lineGames = processInput.run(input);
            History Historic = new History(lineGames);
            long result = Historic.predict();

            assertThat(result, equalTo(114L));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("File not found: " + input);
        } catch (IOException e) {
            e.printStackTrace();
            fail("I/O error: " + input);
        }


    }
}
