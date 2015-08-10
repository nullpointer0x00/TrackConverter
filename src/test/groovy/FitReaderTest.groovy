import spock.lang.*;


class FitReaderTest extends Specification{

	def fitFile
	
	def setup() {
		def path = this.getClass().getClassLoader().getResource("test.FIT").getFile()
		fitFile = new File(path)
	}
	
	def "test read of fit file into SimpleTrack"(){
		when: 
			def track = new SimpleTrack(trackPoints: new LinkedList<SimpleTrack>())
			def reader = new FitReader()
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

}
