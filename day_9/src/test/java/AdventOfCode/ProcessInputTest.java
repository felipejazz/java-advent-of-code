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
    public void exampleInput() throws IOException {
        ProcessInput processInput = new ProcessInput();
        String inputPath = "./test/input.txt";
        List<String> lineGames = processInput.run(inputPath);

        int result = Main.processGames(lineGames);

        assertThat(result, equalTo(114));
    }
}
