import spock.lang.*;


class UtilsSpec extends Specification {

    @Unroll
    def "test semi-circles converter: #name"() {
        setup:
        def result = Utils.convertSemiCircles(semi)

        expect:
        result == expected
        where:
        name                 | semi      | expected
        "Actual semi-circle" | 536137868 | 44.93855696171522
        "Zero"               | 0         | 0
        "Negative"           | 0         | 0
    }

    def "test zulu timestamp converter"() {
        when:
        def now = Calendar.getInstance()
        def result = Utils.toZuluTimestamp(now)
        then:
        result.length() == 20
        result.contains("T")
        result.contains("Z")
    }
}
