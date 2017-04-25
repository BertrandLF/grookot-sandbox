package codewars

import spock.lang.Specification

class LineSpec extends Specification {


    def "first person must have exact amount"() {
        when:
        int[] people = [50, 25, 25, 50, 100]

        then:
        Line.Tickets(people) == "NO"
    }

    def "can give change"() {
        when:
        int[] people = [25, 25, 50]

        then:
        Line.Tickets(people) == "YES"
    }

    def "cannot give change"() {
        when:
        int[] people = [25, 100]

        then:
        Line.Tickets(people) == "NO"
    }

}
