package AdventOfCode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
    

   
public class Main {
  public static void main(String[] args) {
      if (args.length >= 2) {
        
          ProcessInput processInput = new ProcessInput();
          ArrayList<HashMap<String, Integer>> processedGames;
          try {
              processedGames = processInput.process(args[0]);
          } catch (FileNotFoundException e) {
              e.printStackTrace();
              throw new IllegalArgumentException("File not found: " + args[0], e);
          } catch (IOException e) {
              e.printStackTrace();
              throw new IllegalArgumentException("Error reading file: " + args[0], e);
          }
          HashMap<String, Integer> arrayBaseGame;
          try {
              arrayBaseGame = processInput.process(args[1]).get(0);
          } catch (FileNotFoundException e) {
              e.printStackTrace();
              throw new IllegalArgumentException("File not found: " + args[1], e);
          } catch (IOException e) {
              e.printStackTrace();
              throw new IllegalArgumentException("Error reading file: " + args[1], e);
          }
          Integer result = processInput.match(arrayBaseGame, processedGames);
          System.out.println(result);
      } else {
          throw new IllegalArgumentException("Please specify input path.");
      }
  }
}

