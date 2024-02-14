package AdventOfCode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//--- Day 8: Haunted Wasteland ---
//You're still riding a camel across Desert Island when you spot a sandstorm quickly approaching. When you turn to warn the Elf, she disappears before your eyes! To be fair, she had just finished warning you about ghosts a few minutes ago.
//
//One of the camel's pouches is labeled "maps" - sure enough, it's full of documents (your puzzle input) about how to navigate the desert. At least, you're pretty sure that's what they are; one of the documents contains a list of left/right instructions, and the rest of the documents seem to describe some kind of network of labeled nodes.
//
//It seems like you're meant to use the left/right instructions to navigate the network. Perhaps if you have the camel follow the same instructions, you can escape the haunted wasteland!
//
//After examining the maps for a bit, two nodes stick out: AAA and ZZZ. You feel like AAA is where you are now, and you have to follow the left/right instructions until you reach ZZZ.
//
//This format defines each node of the network individually. For example:
//
//RL
//
//AAA = (BBB, CCC)
//BBB = (DDD, EEE)
//CCC = (ZZZ, GGG)
//DDD = (DDD, DDD)
//EEE = (EEE, EEE)
//GGG = (GGG, GGG)
//ZZZ = (ZZZ, ZZZ)
//Starting with AAA, you need to look up the next element based on the next left/right instruction in your input. In this example, start with AAA and go right (R) by choosing the right element of AAA, CCC. Then, L means to choose the left element of CCC, ZZZ. By following the left/right instructions, you reach ZZZ in 2 steps.
//
//        Of course, you might not find ZZZ right away. If you run out of left/right instructions, repeat the whole sequence of instructions as necessary: RL really means RLRLRLRLRLRLRLRL... and so on. For example, here is a situation that takes 6 steps to reach ZZZ:
//
//LLR
//
//AAA = (BBB, BBB)
//BBB = (AAA, ZZZ)
//ZZZ = (ZZZ, ZZZ)
//Starting at AAA, follow the left/right instructions. How many steps are required to reach ZZZ?
//
//Your puzzle answer was 22357.



public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please specify input path.");
            System.exit(1);
        }

        String inputPath = args[0];
        ProcessInput processInput = new ProcessInput();
        try {
            List<String> lineGames = processInput.run(inputPath);
            int sum = processGames(lineGames);
            System.out.println("Sum: " + sum);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputPath);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading file: " + inputPath);
            e.printStackTrace();
        }
    }
    public static int rowCalc(int[] inputArray){
        int[] calcArray = new int[inputArray.length-1];
        for (int i = 1; i < inputArray.length; i++) {
            calcArray[i-1] = inputArray[i] - inputArray[i-1];
        }
        System.out.println(Arrays.toString(calcArray));

        boolean allZero = Arrays.stream(calcArray).allMatch((i) -> i == 0);
        if (allZero){
            return 0;
        } else {
            return calcArray[calcArray.length-1] + rowCalc(calcArray);

        }
    }
    public static int processGames(List<String> lineGames) {
        int sum = 0;
        for (String line : lineGames) {
            String[] sSequence = line.split(" ");
            int[] sequence = new int[sSequence.length];
            for (int i = 0; i < sSequence.length; i++) {
                sequence[i] = Integer.parseInt(sSequence[i]);
            }
            System.out.println(Arrays.toString(sequence));
            int nextValue = sequence[sequence.length - 1] + rowCalc(sequence);
            System.out.println(nextValue);
            sum += nextValue;
        }
        return sum;
    }
}


