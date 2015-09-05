import spock.lang.*;


class FitReaderSpec extends BaseSpec {


    def "test read of fit file into SimpleTrack"() {

        setup:
        def track = new SimpleTrack(trackPoints: new LinkedList<SimpleTrack>())
        def reader = new FitReader()
        def fitFile = getTestResourceFile("test.FIT")

        when:
        reader.read(fitFile, track)

        then:
        track.getTrackPoints().size() == 163
        track.getTrackPoints().each {
            assert it.alt == null
            assert it.lat != null
            assert it.lon != null
            assert it.timeStamp != null
        }
    }

    def "fail integrity check"() {

        when:
        def track = new SimpleTrack(trackPoints: new LinkedList<SimpleTrack>())
        def reader = new FitReader()
        def fitFile = getTestResourceFile("testBad.FIT")
        reader.read(fitFile, track)

        then:
        thrown(Exception)
    }

    def "fail sample track null pointer tracklist"() {

        when:
        def track = new SimpleTrack()
        def reader = new FitReader()
        def fitFile = getTestResourceFile("test.FIT")
        reader.read(fitFile, track)

        then:
        thrown(NullPointerException)
    }

    def "fail sample track null pointer"() {

        when:
        def track = new SimpleTrack(trackPoints: new LinkedList<SimpleTrack>())
        def reader = new FitReader()
        def fitFile = getTestResourceFile("test.FIT")
        reader.read(fitFile, null)

        then:
        thrown(NullPointerException)

    }

    def "fail null file"() {

        when:
        def track = new SimpleTrack(trackPoints: new LinkedList<SimpleTrack>())
        def reader = new FitReader()
        reader.read(null, track)

        then:
        thrown(GroovyRuntimeException)
    }
}
