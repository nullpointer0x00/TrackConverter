import spock.lang.Specification


class GpxReaderSpec extends BaseSpec{

    def "read gpx file"(){

        setup:
        def gpxFile = getTestResourceFile("test.gpx")
        def reader = new GpxReader()
        SimpleTrack tracks = new SimpleTrack(trackPoints: new LinkedList<SimpleTrack>())
        when:
        reader.read(gpxFile, tracks)
        then:
        tracks.name == "Afternoon Ride"
        tracks.trackPoints?.size() == 5
        tracks.trackPoints.each{
            assert it.timeStamp instanceof org.joda.time.DateTime
        }
    }

}
