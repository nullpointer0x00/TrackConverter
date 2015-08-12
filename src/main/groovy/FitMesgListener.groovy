import com.garmin.fit.RecordMesg;
import com.garmin.fit.RecordMesgListener;


class FitMesgListener implements RecordMesgListener {

		SimpleTrack simpleTrack
		
		@Override
		public void onMesg(RecordMesg recordMesg) {
			//println "Record Mesg " + arg0.getTimestamp().getDate().toGMTString() + " " + convertSemiCircles(arg0.getPositionLat()) + " " + convertSemiCircles(arg0.getPositionLong()) + " " + arg0.getAltitude() + " "
			def trackPoint = new SimpleTrackPoint(timeStamp: recordMesg.getTimestamp().getDate().toCalendar(), 
													lat: Utils.convertSemiCircles(recordMesg.getPositionLat()),
													lon: Utils.convertSemiCircles(recordMesg.getPositionLong()),
													alt: recordMesg.getAltitude())
			simpleTrack.getTrackPoints().add(trackPoint)
			
		}
}
