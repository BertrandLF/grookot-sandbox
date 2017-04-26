package codewars;

import java.util.stream.IntStream;

public class OddTriangle {

    public static int rowSumOddNumbers(int level) {
        return level * level * level;
    }

    public static int rowSumOddNumbers2(int level) {
        int nodesAtLevel = nbNodesAtLevel(level);
        int capEven = 2 * nodesAtLevel;
        int lowEven = 2 * nbNodesAtLevel(level - 1);
        return IntStream.range(lowEven, capEven).filter(n -> n % 2 != 0).sum();
    }

    public static int nbNodesAtLevel(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return n + nbNodesAtLevel(n - 1);
        }
    }
}
