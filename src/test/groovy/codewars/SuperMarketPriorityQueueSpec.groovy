package codewars

import spock.lang.Specification

/**
 * Created by blefoulgoc on 5/1/17.
 */
class SuperMarketPriorityQueueSpec extends Specification {

    def "compute simple 2 people queue, one till"() {
        when:
        int[] queue = [3, 6]
        int tills = 1

        then:
        SuperMarketPriorityQueue.computeTime(queue, tills) == 9

    }

    def "compute simple 2 people queue, two tills"() {
        when:
        int[] queue = [3, 6]
        int tills = 2

        then:
        SuperMarketPriorityQueue.computeTime(queue, tills) == 6
    }

    def "empty queue, one till should return 0"() {
        expect:
        SuperMarketPriorityQueue.computeTime([] as int[], 1) == 0
    }

    def "no till, descent queue should..."() {
        expect:
        SuperMarketPriorityQueue.computeTime([2, 3] as int[], 0) == 0
    }

}
