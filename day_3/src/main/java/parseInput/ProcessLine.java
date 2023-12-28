package parseInput;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessLine {
    public ArrayList<Integer> process(String line1, String line2, String line3){


        String currentStringLoopNumber = "";        
        Integer indexBegin = - 1;
        IsNumeric isNumeric = new IsNumeric();
        ArrayList<Integer> numberList = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^A-Za-z0-9.]");


        for (int i = 0; i < line1.length(); i++) {
            char currentChar = line1.charAt(i);
            String currentCharString = String.valueOf(currentChar);
            if (isNumeric.checkType(currentCharString)) {
                if (indexBegin == -1){
                    indexBegin = i;
                }
                currentStringLoopNumber = currentStringLoopNumber.concat(currentCharString);
                char nextChar;
                String nextStringChar;
                if (i + 1 < line1.length()) {
                    nextChar = line1.charAt(i + 1);
                    nextStringChar = String.valueOf(nextChar);
                    if (!isNumeric.checkType(nextStringChar)) {
                        Integer actualNumber = Integer.valueOf(currentStringLoopNumber);

                        if (indexBegin != 0) {
                            indexBegin = indexBegin - 1;
                        }
                        Matcher matcher1 = pattern.matcher(nextStringChar);

                        if (matcher1.find()){
                            numberList.add(actualNumber);
                            currentStringLoopNumber = "";
                            indexBegin = -1;
                            
                        }
                        if ( ((currentStringLoopNumber.length() + 2) <= line1.length())) {
                            String previousLineSubString = null;
                            String nextLineSubString = null;
                            if (indexBegin >= 0 && line2 != null){
                                nextLineSubString = line2.substring((indexBegin), (indexBegin + (currentStringLoopNumber.length() + 2)));
                            }
                            if (indexBegin >= 0 && line3 != null){
                                previousLineSubString = line3.substring((indexBegin), (indexBegin + (currentStringLoopNumber.length() + 2)));
                            } 

                            if (nextLineSubString != null) {
                                Matcher matcher2 = pattern.matcher(nextLineSubString);
                                if (matcher2.find()) {
                                   numberList.add(actualNumber);
                                   currentStringLoopNumber = "";
                                   indexBegin = -1;
                                   
                                } else {
                                   currentStringLoopNumber = "";
                                   indexBegin = -1;
                                }
                            }
                            if (previousLineSubString != null) {
                                Matcher matcher2 = pattern.matcher(previousLineSubString);
                                if (matcher2.find()) {
                                   numberList.add(actualNumber);
                                   currentStringLoopNumber = "";
                                   indexBegin = -1;
                                   
                                } else {
                                   currentStringLoopNumber = "";
                                   indexBegin = -1;
                                }
                            }
                        }
                    }
                }
            }   
        }
        return numberList;
    }
}

    
