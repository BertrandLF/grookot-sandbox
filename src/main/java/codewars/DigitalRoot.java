package codewars;

/**
 * Created by blefoulgoc on 4/27/17.
 */
public class DigitalRoot {

    public static int compute(int input) {
        int result = input;
        while (result > 10) {
            result = addDigits(result);
        }
        return result;
    }

    private static int addDigits(int input) {
        return String.valueOf(input).chars().reduce(0, (a, b) -> a + Character.getNumericValue(b));
    }
}
