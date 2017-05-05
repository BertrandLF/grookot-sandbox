package codewars

import spock.lang.Specification

/**
 * Created by blefoulgoc on 5/2/17.
 */
class PrimesInNumberSpec extends Specification {

    def "decompose small non prime in two primes" () {
        expect:
        PrimesInNumber.factors(15) == "(3)(5)"
    }

    def "decompose into product of primes from smallest" () {
        expect:
            PrimesInNumber.factors(7775460) == "(2**2)(3**3)(5)(7)(11**2)(17)"
    }

}
