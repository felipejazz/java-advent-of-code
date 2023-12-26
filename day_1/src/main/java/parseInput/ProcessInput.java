package parseInput;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProcessInput {
    
    public int processInput(String filePath) {
        TypeChecker typeChecker = new TypeChecker();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<Character> letters = new ArrayList<>();
            List<Integer> numbers = new ArrayList<>();
            System.out.println(br);
            String line;
            int finalCounter = 0;
            while ((line = br.readLine()) != null ){
                for (int i = 0; i < line.length(); i++){
                    char character = line.charAt(i);
                    if (typeChecker.checkType(String.valueOf(character)) == ("String")) {
                        letters.add(character);
                    } else {
                        int num = Character.getNumericValue(character);
                        numbers.add(num);
                    }
                }
                int firstNum = numbers.get(0);
                int lastNum = numbers.get(numbers.size()-1);
                int concatenatedNums = Integer.parseInt(String.valueOf(firstNum) + String.valueOf(lastNum));
                finalCounter += concatenatedNums;

                letters.clear();
                numbers.clear();
            }
            return finalCounter;
        } 
        catch (IOException e) {
           e.printStackTrace();
           return -1;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java parseInput.ProcessInput <caminho_do_arquivo>");
            System.exit(1);
        }

        String filePath = args[0];
        ProcessInput processInput = new ProcessInput();
        int result = processInput.processInput(filePath);

        if (result != -1) {
            System.out.println("Resultado: " + result);
        } else {
            System.out.println("Ocorreu um erro ao processar o arquivo.");
        }
    }
}
