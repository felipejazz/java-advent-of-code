package parseInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessInput {
public int process(String INPUTPATH) throws FileNotFoundException, IOException {
    File file = new File(INPUTPATH);

    if (!file.exists() || file.length() == 0) {
        throw new IllegalArgumentException("Empty file or file not found: " + INPUTPATH);
    }
    

    try (BufferedReader br = new BufferedReader(new FileReader(INPUTPATH))) {
        String line;
        String previousLine = null;
        String currentLine;
        String nextLine = null;
        ProcessLine processLine = new ProcessLine();
        ArrayList<Integer> numberList = new ArrayList<>(); 
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Integer> actualLoop = new ArrayList<>(); // Inicialização de actualLoop
        
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        for (int i = 0; i < lines.size(); i++){
            

            currentLine = lines.get(i);
            if (i > 0){
                previousLine = lines.get(i-1);
            }
            if (i< lines.size() - 1){
                nextLine = lines.get(i+1);
            }
            if (i <= lines.size()-1){
                actualLoop= processLine.process(currentLine, nextLine, previousLine);
            }
            for (int number: actualLoop){
                numberList.add(number);
            }
        }
        int result = 0;
        for(int number: numberList){
            result += number;

        }
        return result;
    }
}
}
