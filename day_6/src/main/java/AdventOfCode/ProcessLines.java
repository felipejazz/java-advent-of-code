package AdventOfCode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessLines {


    public int run (List<String> lines ) {
        RaceManager RaceManager = new RaceManager();
        for (String line: lines ) {

            processLine(line, RaceManager);

        }
        return RaceManager.runRaces();

    }

    private void processLine (String line, RaceManager RaceManager) {



        Pattern TimePattern = Pattern.compile("^(Time:*\\s*)");
        Matcher TimeMatcher = TimePattern.matcher(line);
        Pattern DistancePattern = Pattern.compile("^(Distance:*\\s*)");
        Matcher DistanceMatcher = DistancePattern.matcher(line);

        if (TimeMatcher.find()) {
            Pattern SpacePattern = Pattern.compile("\\d+");
            Matcher SpaceMatcher = SpacePattern.matcher(line);
            List<Integer> timeList = new ArrayList<>();

            while (SpaceMatcher.find()) {
                int timeTemp = Integer.parseInt(SpaceMatcher.group());
                timeList.add(timeTemp);
            }
            RaceManager.setTimes(timeList);
        }
        if (DistanceMatcher.find()) {
            Pattern SpacePattern = Pattern.compile("\\d+");
            Matcher SpaceMatcher = SpacePattern.matcher(line);
            List<Integer> recordList = new ArrayList<>();

            while (SpaceMatcher.find()) {
                int recordTemp = Integer.parseInt(SpaceMatcher.group());
                recordList.add(recordTemp);
            }
            RaceManager.setRecords(recordList);
        }
    }
}
