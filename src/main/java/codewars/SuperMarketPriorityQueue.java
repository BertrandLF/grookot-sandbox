package codewars;

import java.util.PriorityQueue;

/**
 * Created by blefoulgoc on 5/1/17.
 */
public class SuperMarketPriorityQueue {

    public static int computeTime(int[] queue, int nbTills) {
        
        if (queue.length == 0 || nbTills == 0)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(nbTills);
        //fill priority queue from 0 until nbTills
        for (int i = 0; i < nbTills && i < queue.length; i++) {
            pq.offer(queue[i]);
        }
        //add remaining customers in tills from less charged to most
        for (int i = nbTills; i < queue.length; i++) {
            pq.offer(pq.poll() + queue[i]);
        }
        //poll until the biggest remains
        while (pq.size() > 1)
            pq.poll();
        //return last in queue
        return pq.poll();
    }

}
