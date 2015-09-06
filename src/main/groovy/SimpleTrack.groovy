import groovy.transform.Canonical
import org.joda.time.DateTime

@Canonical
class SimpleTrack {

	String name
	List<SimpleTrackPoint> trackPoints
	
	DateTime getTime(){
		if(trackPoints != null && trackPoints.size() > 0){
			return trackPoints.get(0).getTimeStamp()
		}
	}
	
}
