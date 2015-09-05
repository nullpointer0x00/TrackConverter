import groovy.transform.Canonical

@Canonical
class SimpleTrack {

	String name
	List<SimpleTrackPoint> trackPoints
	
	Calendar getTime(){
		if(trackPoints != null && trackPoints.size() > 0){
			return trackPoints.get(0).getTimeStamp()
		}
	}
	
}
