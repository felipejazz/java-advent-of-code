package parseInput;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

public class ParseInputTest {
  
    private ProcessInput processInput = new ProcessInput();

    @Test
    public void day1Example() {
      
      String[] args = {"/home/felipe-tarvos/repos/java_aoc/day_1/src/test/input.txt"};
      assertEquals(142, processInput.processInput(args[0]));
    }
}
