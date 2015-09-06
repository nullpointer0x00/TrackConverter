import spock.lang.Specification;


class SimpleTrackSpec extends Specification{

	void "test get time on null trackPoint list"(){
		when:
			def simpleTrack = new SimpleTrack()
			def time = simpleTrack.getTime()
		then:
			time == null
	}
	
	void "test get time on empty trackPoint list"(){
		when:
			def simpleTrack = new SimpleTrack(trackPoints: new LinkedList<SimpleTrackPoint>())
			def time = simpleTrack.getTime()
		then:
			time == null
	}
	
	void "test get time on trackPoint list"(){
		when:
			def simpleTrack = new SimpleTrack(trackPoints: new LinkedList<SimpleTrackPoint>())
			def timestamp = new org.joda.time.DateTime()
			def trackPoint = new SimpleTrackPoint(timeStamp: timestamp)
			simpleTrack.getTrackPoints().add(trackPoint)
			def time = simpleTrack.getTime()
		then:
			time == timestamp
	}
}
