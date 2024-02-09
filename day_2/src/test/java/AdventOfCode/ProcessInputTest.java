package AdventOfCode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class ProcessInputTest {
    ProcessInput processInput = new ProcessInput();

    @Test
    public void exampleInput() {
      String basegame = "./test/basegame.txt";
      String input = "./test/input.txt";
    
      HashMap<String, Integer> arrayBaseGame = null;
      ArrayList<HashMap<String, Integer>> processedGames = null;
      ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 5));
    
      try {
          arrayBaseGame = processInput.process(basegame).get(0);
      } catch (FileNotFoundException e) {
          e.printStackTrace();
          fail("File not found: " + basegame);
      } catch (IOException e) {
          e.printStackTrace();
          fail("I/O error: " + basegame);
      }
    
      try {
          processedGames = processInput.process(input);
      } catch (FileNotFoundException e) {
          e.printStackTrace();
          fail("File not found: " + input);
      } catch (IOException e) {
          e.printStackTrace();
          fail("I/O error: " + input);
      }
      Integer counter = 0;
      for ( Integer expectedId: expectedList ){
        counter += expectedId;
      };
      assertThat(processInput.match(arrayBaseGame, processedGames), equalTo(counter));
    }



    
}
