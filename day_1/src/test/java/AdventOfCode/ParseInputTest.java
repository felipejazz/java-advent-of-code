package AdventOfCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParseInputTest {
  
    private ProcessInput processInput = new ProcessInput();

    @Test
    public void day1Example() {
      
      String[] args = {"test/input.txt"};
      assertEquals(142, processInput.processInput(args[0]));
    }
}
