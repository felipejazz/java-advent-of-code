package AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class History {

    private List<String> sequences;

    public History(List<String> sequences) {
        this.sequences = sequences;
    }

    public List<String> getSequences() {
        return sequences;
    }

    public void setSequences(List<String> sequences) {
        this.sequences = sequences;
    }

    private List<List<ArrayList<Long>>> differences = new ArrayList<>();


    public long predict() {
        long totalPrediction = 0;
        for (String sequence : sequences) {
            DifferenceProcessor differenceProcessor = new DifferenceProcessor(sequence);
            totalPrediction += differenceProcessor.predictNextValue();
        }
        return totalPrediction;
    }
}
