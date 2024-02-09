package parseInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessLines {

    private ArrayList<Integer> matchRegex(String line) {
        ArrayList<Integer> symbolIndexes = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^A-Za-z0-9.]");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            symbolIndexes.add(matcher.start());
        }
        return symbolIndexes;
    }

    private List<Map<String, Object>> mapLine(String line) {
        List<Map<String, Object>> numberDetailsList = new ArrayList<>();
        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher numberMatcher = numberPattern.matcher(line);

        while (numberMatcher.find()) {
            Map<String, Object> numberDetails = new HashMap<>();
            numberDetails.put("value", Integer.parseInt(numberMatcher.group()));
            numberDetails.put("begin", numberMatcher.start());
            numberDetails.put("end", numberMatcher.end() - 1);
            numberDetailsList.add(numberDetails);
        }

        return numberDetailsList;
    }

    private boolean isAdjacentToSymbol(Map<String, Object> numberDetails, List<Integer> prev, List<Integer> current, List<Integer> next, String prevLine, String currentLine, String nextLine) {
        int beginIndex = (Integer) numberDetails.get("begin");
        int endIndex = (Integer) numberDetails.get("end");

        for (Integer index : current) {
            if (index >= beginIndex - 1 && index <= endIndex + 1) {
                return true;
            }
        }
        for (Integer index : prev) {
            if (Math.abs(index - beginIndex) <= 1 || Math.abs(index - endIndex) <= 1) {
                return true;
            }
        }
        for (Integer index : next) {
            if (Math.abs(index - beginIndex) <= 1 || Math.abs(index - endIndex) <= 1) {
                return true;
            }
        }

        return false;
    }

    public int run(List<String> schematicLines) {
        int sum = 0;
        List<Integer> symbolIndexesPrev = new ArrayList<>();
        List<Integer> symbolIndexesCurrent = new ArrayList<>();
        List<Integer> symbolIndexesNext = new ArrayList<>();

        for (int i = 0; i < schematicLines.size(); i++) {
            String currentLine = schematicLines.get(i);
            String nextLine = i < schematicLines.size() - 1 ? schematicLines.get(i + 1) : "";
            symbolIndexesPrev = symbolIndexesCurrent;
            symbolIndexesCurrent = symbolIndexesNext;
            symbolIndexesNext = matchRegex(nextLine);

            List<Map<String, Object>> numbersInLine = mapLine(currentLine);

            for (Map<String, Object> numberDetails : numbersInLine) {
                if (isAdjacentToSymbol(numberDetails, symbolIndexesPrev, symbolIndexesCurrent, symbolIndexesNext, i > 0 ? schematicLines.get(i - 1) : "", currentLine, nextLine)) {
                    sum += (Integer) numberDetails.get("value");
                }
            }
        }

        return sum;
    }
}
