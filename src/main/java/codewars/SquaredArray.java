package codewars;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquaredArray {

    public static boolean comp(int[] a, int[] b) {
        if (a == b) return true;
        if (a.length == b.length) {
            List<Integer> aList = toList(a);
            List<Integer> bList = toList(b);

            aList.sort(Comparator.naturalOrder());
            bList.sort(Comparator.naturalOrder());

            aList.forEach(va -> {
                int squared = va * va;
                if (bList.indexOf(squared) != -1)
                    bList.remove(bList.indexOf(squared));
            });
            return (bList.isEmpty());
        } else {
            return false;
        }
    }

    private static List<Integer> toList(int[] a) {
        return IntStream.of(a).boxed().collect(Collectors.toList());
    }

}
