package AdventOfCode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class Main {
  public static void main(String[] args) {
      if (args.length >= 1) {
        
          ProcessInput processInput = new ProcessInput();
          ProcessLines processLines = new ProcessLines();
          List<String> lineGames;
          try {
              lineGames = processInput.run(args[0]);
              int result = processLines.run(lineGames);

              System.out.println(result);

          } catch (FileNotFoundException e) {
              e.printStackTrace();
              throw new IllegalArgumentException("File not found: " + args[0], e);
          } catch (IOException e) {
              e.printStackTrace();
              throw new IllegalArgumentException("Error reading file: " + args[0], e);
          }          
      } else {
          throw new IllegalArgumentException("Please specify input path.");
      }
  }
}
