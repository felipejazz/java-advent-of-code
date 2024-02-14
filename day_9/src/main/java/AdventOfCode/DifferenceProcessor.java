    package AdventOfCode;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class DifferenceProcessor {

        private String sequenceString;
        public ArrayList<Long> sequence;
        private List<ArrayList<Long>> differences;


        public DifferenceProcessor (String sequenceString){
            this.sequenceString = sequenceString;
            ArrayList<Long> sequence = new ArrayList<>();
            Pattern spacePattern = Pattern.compile("\\d*");
            Matcher spaceMatcher = spacePattern.matcher(this.sequenceString);
            while (spaceMatcher.find()){
                if(!spaceMatcher.group().isEmpty()){
                    sequence.add(Long.parseLong(spaceMatcher.group()));
                }
            }
            this.sequence = sequence;
        }

        private List<ArrayList<Long>> calculateDifference(ArrayList<Long> sequence) {
            List<ArrayList<Long>> differences = new ArrayList<>();

            ArrayList<Long> currentDiffs = new ArrayList<>();
            for (int i = 0; i < sequence.size() - 1; i++) {
                currentDiffs.add(sequence.get(i + 1) - sequence.get(i));
            }

            differences.add(new ArrayList<>(currentDiffs));

            while (!isAllZero(currentDiffs)) {
                ArrayList<Long> nextDiffs = new ArrayList<>();
                for (int i = 0; i < currentDiffs.size() - 1; i++) {
                    nextDiffs.add(currentDiffs.get(i + 1) - currentDiffs.get(i));
                }

                differences.add(new ArrayList<>(nextDiffs));
                currentDiffs = nextDiffs;
            }

            return differences;
        }

        private boolean isAllZero(ArrayList<Long> list) {
            for (long item : list) {
                if (item != 0) return false;
            }
            return true;
        }
        private long extrapolateNextValue(List<ArrayList<Long>> differences) {

            for (int i = differences.size() - 2; i >= 0; i--) {
                List<Long> prev = differences.get(i);
                List<Long> current = differences.get(i + 1);
                prev.add(prev.get(prev.size() - 1) + current.get(current.size() - 1));
            }

            long lastValueOfOriginalSequence = this.sequence.get(this.sequence.size() - 1);
            long lastDifference = differences.get(0).get(differences.get(0).size() - 1);

            long predictedNextValue = lastValueOfOriginalSequence + lastDifference;
            System.out.println("Predict: " + predictedNextValue);
            return predictedNextValue;
        }


        public long predictNextValue() {
            List<ArrayList<Long>> differences = calculateDifference(this.sequence);
            printSequences(differences);

            return extrapolateNextValue(differences);
        }


        public void printSequences(List<ArrayList<Long>> differences) {
            int maxLengthOfSequence = differences.stream().mapToInt(List::size).max().orElse(2);

            int maxNumberWidth = differences.stream()
                    .flatMap(List::stream)
                    .mapToInt(num -> String.valueOf(num).length())
                    .max()
                    .orElse(2) + 2;

            printSequence(this.sequence, 0, maxNumberWidth);
            for (ArrayList<Long> sequence : differences) {
                int padding =  2 + maxNumberWidth * (maxLengthOfSequence - sequence.size()) / 2;

                printSequence(sequence, padding, maxNumberWidth);

            }
        }

        public void printSequence(ArrayList<Long> sequenceToPrint, int padding, int maxNumWidth) {
            System.out.print(" ".repeat(padding));
            for (long num : sequenceToPrint) {
                System.out.printf("%-" + maxNumWidth + "d", num);
            }
            System.out.println();
        }

        private boolean checkZeroSequence(ArrayList<Long> sequence) {

            for (long num : sequence) {
                if (num != 0) {
                    return false;
                }
            }
            return true;
        }


    }
