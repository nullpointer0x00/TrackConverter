import spock.lang.Specification;


class GpxWriterTest extends Specification{

	def "test gpx writter expect null pointer"(){
		when:
			def gpxWriter = new GpxWriter()
			gpxWriter.write()
		then:
			thrown(NullPointerException)
				
	}
	
	def "test gpx writter empty list"(){
		when:
			def simpleTrack = new SimpleTrack(trackPoints: new LinkedList<SimpleTrackPoint>())
			def gpxWriter = new GpxWriter(simpleTrack: simpleTrack)
			gpxWriter.write()
		then:
			1 == 1
				
	}
}
