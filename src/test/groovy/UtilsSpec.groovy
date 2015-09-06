import org.joda.time.DateTime
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

    @Unroll
    def "test zulu timestamp converter"() {
        setup:
        def result = Utils.toZuluTimestamp(time)
        expect:
        result == expectedResult
        where:
        time                                                         | expectedResult
        new DateTime(2015, 9, 5, 12, 0, 0, 0)                           | "2015-09-05T17:00:00Z"
        new DateTime(2015, 9, 5, 12, 0, 0, 0).toDate()                  | "2015-09-05T17:00:00Z"
        new DateTime(2015, 9, 5, 12, 0, 0, 0).toCalendar(Locale.CANADA) | "2015-09-05T17:00:00Z"
        new Object()                                                    | null
        null                                                            | null
    }

    def "test zulu timestamp string to calendar"(){
        setup:
        def zulu = "2015-09-02T21:30:45Z"
        when:
        def cal = Utils.convertZuluTimestamp(zulu)
        then:
        cal

    }

    def "test zulu timestamp string to dt to string"(){
        setup:
        def zulu = "2015-09-02T21:30:45Z"
        when:
        def cal = Utils.convertZuluTimestamp(zulu)
        then:
        cal
        when:
        def zuluResult = Utils.toZuluTimestamp(cal)
        then:
        zuluResult == zulu
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
        44.8640380 | -93.3067340 | 44.9124670 | -93.3093030 | 3.346114174501283

    }
}
