package codewars

import spock.lang.Specification

class SquaredArraySpec extends Specification {

    def "is squared array"() {

        when: "two arrays, one being the square of the other"
            int[] a = [121, 144, 19, 161, 19, 144, 19, 11]
            int[] b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]

        then: "they are 'comp' (I didn't write the requirements)"
            SquaredArray.comp(a, b)
    }

    def "is not squared array"() {

        when: "two arrays, one being the square of the other"
            int[] a = [121, 144, 19, 161, 19, 144, 19, 11]
            int[] b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]

        then: "they are 'comp' (I didn't write the requirements)"
            !SquaredArray.comp(a, b)
    }

    def "empty arrays"() {
        when: "two arrays, one being the square of the other"
        int[] a = []
        int[] b = []

        then: "they are 'comp' (I didn't write the requirements)"
        SquaredArray.comp(a, b)
    }

    def "null arrays"() {
        when: "two arrays, one being the square of the other"
        int[] a = null
        int[] b = null

        then: "they are 'comp' (I didn't write the requirements)"
        SquaredArray.comp(a, b)
    }
}
