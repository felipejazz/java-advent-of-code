package AdventOfCode;

import java.util.ArrayList;
import java.util.List;

class RaceManager {

    private List<Integer> times = new ArrayList<>();
    private List<Integer> records = new ArrayList<>();

    public void setTimes(List<Integer> times) {
        this.times = times;
    }

    public List<Integer> getTimes () {
        return this.times;
    }

    public void setRecords(List<Integer> records) {
        this.records = records;
    }

    public List<Integer> getRecords(){
        return this.records;
    }


    public int runRaces() {

        List<Integer> times = getTimes();
        List<Integer> records = getRecords();
        int numberOfWays = 1;
        for (int i=0; i < times.size(); i++) {
            int timeLimit = times.get(i);
            int timeLoop = 1;
            int numWins = 0;
            int recordToBeat = records.get(i);

            while(timeLoop <= timeLimit) {
                int timeToTravel = timeLimit - timeLoop;
                int distanceTraveled = timeLoop * timeToTravel;
                if (distanceTraveled > recordToBeat) {
                    numWins +=1;
                }
                timeLoop += 1;
            }
            if (numWins > 0) {
                numberOfWays *= numWins;
            }
        }
        return numberOfWays;
    }
}