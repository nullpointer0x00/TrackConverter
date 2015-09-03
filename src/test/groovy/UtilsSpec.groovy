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

    @Unroll
    def "test distance between two points in km"() {
        setup:
        def result = Utils.distanceInKm(lat1, lon1, lat2, lon2)
        expect:
        result == expected
        where:
        lat1       | lon1        | lat2       | lon2        | expected
        0.0        | 0.0         | 0.0        | 0.0         | 0.0
        44.8640380 | -93.3067340 | 44.9124670 | -93.3093030 | 5.385059102469194

    }

    @Unroll
    def "test distance between two points in Miles"() {
        setup:
        def result = Utils.distanceInMi(lat1, lon1, lat2, lon2)
        expect:
        result == expected
        where:
        lat1       | lon1        | lat2       | lon2        | expected
        0.0        | 0.0         | 0.0        | 0.0         | 0.0
        44.8640380 | -93.3067340 | 44.9124670 | -93.3093030 | 3.34611417

    }
}
