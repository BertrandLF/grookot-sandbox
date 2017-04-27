package codewars;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by blefoulgoc on 4/26/17.
 */
public class Order {

    public static String order(String input) {
        if (input != null && !input.isEmpty()) {
            String[] words = input.split(" ");
            String[] result = new String[words.length];

            Pattern p = Pattern.compile("[0-9]");

            Arrays.asList(words).forEach(word -> {
                Matcher m = p.matcher(word);
                if (m.find()) {
                    int index = Character.getNumericValue(word.charAt(m.start()));
                    result[index - 1] = word + " ";
                }
            });
            return Arrays.stream(result).reduce("", String::concat).trim();
        }
        return "";
    }

}
