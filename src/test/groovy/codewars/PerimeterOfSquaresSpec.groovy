package codewars

import spock.lang.Specification

/**
 * Created by blefoulgoc on 5/1/17.
 */
class PerimeterOfSquaresSpec extends Specification {

    def "perimeter sum for 6 (5+1) squares"() {
        expect:
        PerimeterOfSquares.perimeter(5 as BigInteger) == 80
    }
    def "perimeter sum for 8 (7+1) squares"() {
        expect:
        PerimeterOfSquares.perimeter(7 as BigInteger) == 216
    }
    def "perimeter sum for 31 (30+1) squares"() {
        expect:
        PerimeterOfSquares.perimeter(30 as BigInteger) == 14098308
    }

}
