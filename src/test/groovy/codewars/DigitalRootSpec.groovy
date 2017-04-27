package codewars

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by blefoulgoc on 4/27/17.

 */
@Unroll
class DigitalRootSpec extends Specification {

    def "digital roots"() {
        expect:
        DigitalRoot.compute(a) == b

        where:
        a   | b
        12  | 3
        99  | 9
        345 | 3

    }

    def "not digital roots"() {
        expect:
        DigitalRoot.compute(a) != b

        where:
        a   | b
        12  | 12
        99  | 3
        345 | 5

    }

}
