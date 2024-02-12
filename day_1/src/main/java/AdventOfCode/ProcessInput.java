package AdventOfCode;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//--- Day 1: Trebuchet?! ---
//Something is wrong with global snow production, and you've been selected to take a look. The Elves have even given you a map; on it, they've used stars to mark the top fifty locations that are likely to be having problems.
//
//You've been doing this long enough to know that to restore snow operations, you need to check all fifty stars by December 25th.
//
//Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
//
//You try to ask why they can't just use a weather machine ("not powerful enough") and where they're even sending you ("the sky") and why your map looks mostly blank ("you sure ask a lot of questions") and hang on did you just say the sky ("of course, where do you think snow comes from") when you realize that the Elves are already loading you into a trebuchet ("please hold still, we need to strap you in").
//
//As they're making the final adjustments, they discover that their calibration document (your puzzle input) has been amended by a very young Elf who was apparently just excited to show off her art skills. Consequently, the Elves are having trouble reading the values on the document.
//
//The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.
//
//For example:
//
//        1abc2
//        pqr3stu8vwx
//a1b2c3d4e5f
//        treb7uchet
//In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.
//
//Consider your entire calibration document. What is the sum of all of the calibration values?
//
//Your puzzle answer was 54632.



public class ProcessInput {

    public int processInput(String filePath) {
        TypeChecker typeChecker = new TypeChecker();
        int finalCounter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                List<Character> letters = new ArrayList<>();
                List<Integer> numbers = new ArrayList<>();

                for (int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);

                    if ((typeChecker.checkType(String.valueOf(character))) == "String") {
                        letters.add(character);
                    } else {
                        int num = Character.getNumericValue(character);
                        numbers.add(num);
                    }
                }

                if (!numbers.isEmpty()) {
                    int firstNum = numbers.get(0);
                    int lastNum = numbers.get(numbers.size() - 1);
                    int concatenatedNums = Integer.parseInt(String.valueOf(firstNum) + String.valueOf(lastNum));
                    finalCounter += concatenatedNums;
                }

                letters.clear();
                numbers.clear();
            }
        // @TO DO TREAT ERRORS CORRECTLY
            return finalCounter;
        } catch (FileNotFoundException e) {
            System.err.println("File not found " + filePath);
            e.printStackTrace();
            return -1;
        } catch (IOException e) {
            System.err.println("Error reading the file " + filePath);
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            System.err.println("Unexpected error in file processing");
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Use: java parseInput.ProcessInput <path_to_file>");
            System.exit(1);
        }

        String filePath = args[0];
        ProcessInput processInput = new ProcessInput();
        int result = processInput.processInput(filePath);

        if (result != -1) {
            System.out.println("Result: " + result);
        } else {
            System.out.println("An error occurred");
        }
    }
}
