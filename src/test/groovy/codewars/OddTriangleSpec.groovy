package codewars

import spock.lang.Specification

/**
 * Created by blefoulgoc on 4/25/17.
 */
class OddTriangleSpec extends Specification {

    def "sum of first row"() {
        when: "row index is 1"
        int rowIndex = 1

        then: " the sum is 1"
        OddTriangle.rowSumOddNumbers(rowIndex) == 1
    }

    def "nb nodes at 5th row"() {
        expect:
        OddTriangle.nbNodesAtLevel(5) == 15
    }

    def "sum from the 2nd row"() {
        when: "row index is 2"
        int rowIndex = 2

        then: "the sum is 8"
        OddTriangle.rowSumOddNumbers(rowIndex) == 8
    }

    def "sum at 42"() {
        expect: OddTriangle.rowSumOddNumbers(42) == 74088
    }
}
