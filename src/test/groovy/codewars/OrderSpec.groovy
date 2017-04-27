package codewars

import spock.lang.Specification

/**
 * Created by blefoulgoc on 4/26/17.
 */
class OrderSpec extends Specification {

    def "it should order a simple string"() {
        when:
        String input = "is2 Thi1s T4est 3a"

        then:
        Order.order(input) == "Thi1s is2 3a T4est"
    }

    def "it should return an empty string if input is empty"() {
        when:
        String input = ""

        then:
        Order.order(input) == ""
    }

}
