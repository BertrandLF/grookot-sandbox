package codewars;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Created by blefoulgoc on 5/1/17.
 */
public class PerimeterOfSquares {

    private static List<BigInteger> Fibonacci = new ArrayList<>();
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger FOUR = BigInteger.valueOf(4);

    public static BigInteger perimeter(BigInteger nbSquaresMinusOne) {
        BigInteger result = ZERO;
        for (BigInteger bi = ZERO;
             bi.compareTo(nbSquaresMinusOne) <= 0;
             bi = bi.add(ONE)) {
            result = result.add(fibonacci(bi));
        }
        return FOUR.multiply(result);
    }

    private static BigInteger fibonacci(BigInteger n) {
        //we already computed that value
        if (Fibonacci.size() > n.intValue()) {
            return Fibonacci.get(n.intValue());
        }
        //compute and return
        if (n.equals(ZERO) || n.equals(ONE)) {
            Fibonacci.add(n.intValue(), ONE);
        } else {
            Fibonacci.add(n.intValue(),
                    fibonacci(n.subtract(ONE)).add(fibonacci(n.subtract(TWO)))
            );
        }
        return Fibonacci.get(n.intValue());
    }

}
