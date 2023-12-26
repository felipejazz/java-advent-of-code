package parseInput;

public class TypeChecker {
    public String checkType(String  input) {
        try {
            Double.parseDouble(input);
            return "Numeric";
        } catch (NumberFormatException e) {
            return "String";
        }
    }
}