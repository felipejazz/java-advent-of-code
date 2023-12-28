package parseInput;

public class IsNumeric {
    public boolean checkType(String  input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}