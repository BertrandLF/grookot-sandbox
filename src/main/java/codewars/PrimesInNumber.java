package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by blefoulgoc on 5/2/17.
 */
public class PrimesInNumber {

    private static List<Integer> PRIMES = new ArrayList<>();

    public static String factors(int n) {
        HashMap<Integer, Integer> primeFactors = new HashMap<>();
        int prime = 2;
        PRIMES.add(2);
        while (n != 1) {
            while (n % prime == 0) {
                n = n / prime;
                primeFactors.put(prime, primeFactors.getOrDefault(prime, 0) + 1);
            }
            prime = nextPrime(prime + 1);
        }
        StringBuilder result = new StringBuilder();
        List keys = new ArrayList(primeFactors.keySet());
        Collections.sort(keys);
        keys.forEach(key -> {
            int nbTimes = primeFactors.get(key);
            if (nbTimes == 1) {
                result.append("(").append(key).append(")");
            } else {
                result.append("(").append(key).append("**").append(nbTimes).append(")");
            }
        });
        return result.toString();
    }

    private static int nextPrime(int from) {
        int i = from;
        while (true) {
            if (isPrime(i)) {
                PRIMES.add(i);
                return i;
            }
            i++;
        }
    }

    private static boolean isPrime(int i) {
        return (i & 1) != 0
                && PRIMES.stream().noneMatch(prime -> (i % prime == 0 && i != prime));
    }

}
