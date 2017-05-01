package codewars;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by blefoulgoc on 4/28/17.
 */
public class SuperMarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int[] result = new int[n];
        for (int customer : customers) {
            result[0] += customer;
            Arrays.sort(result);
        }
        return result[n-1];
    }

    public static int computeTime(int[] queue, int nbTills) {
        int turns = 0;
        Market market = new Market(queue, new int[nbTills]);
        if (market.isValid()) {
            market.fillTills();
            while (market.peopleWaitAtQueues() || market.aTillIsBusy()) {
                market.tick();
                turns++;
            }
        }
        return turns;
    }

    public static class Market {
        private int[] queue;
        private int[] tills;
        private int nbTills;

        Market(int[] queue, int[] tills) {
            this.queue = queue;
            this.tills = tills;
            this.nbTills = tills.length;
        }

        private void fillTills() {
            for (int i = 0; i < tills.length; i++) {
                if (tills[i] == 0) {
                    int nextInQueue = nextInQueue().orElse(0);
                    tills[i] = queue[nextInQueue];
                    queue[nextInQueue] = 0;
                }
            }
        }

        private void tick() {
            for (int i = 0; i < nbTills; i++) {
                tills[i]--;
            }
            fillTills();
        }

        private boolean peopleWaitAtQueues() {
            return nextInQueue().isPresent();
        }

        private OptionalInt nextInQueue() {
            return IntStream
                    .range(0, this.queue.length)
                    .filter(i -> this.queue[i] > 0)
                    .findFirst();
        }

        private boolean aTillIsBusy() {
            return IntStream
                    .range(0, nbTills)
                    .filter(i -> this.tills[i] > 0)
                    .findAny()
                    .isPresent();
        }

        private boolean isValid() {
            return (nbTills > 0 && queue.length > 0);
        }
    }

}
