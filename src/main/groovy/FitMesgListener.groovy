import com.garmin.fit.RecordMesg;
import com.garmin.fit.RecordMesgListener;


class FitMesgListener implements RecordMesgListener {

		SimpleTrack simpleTrack
		
		@Override
		public void onMesg(RecordMesg arg0) {
			//println "Record Mesg " + arg0.getTimestamp().getDate().toGMTString() + " " + convertSemiCircles(arg0.getPositionLat()) + " " + convertSemiCircles(arg0.getPositionLong()) + " " + arg0.getAltitude() + " "
			def trackPoint = new SimpleTrackPoint(timeStamp: arg0.getTimestamp().getDate().toCalendar(), 
													lat: Utils.convertSemiCircles(arg0.getPositionLat()),
													lon: Utils.convertSemiCircles(arg0.getPositionLong()),
													alt: arg0.getAltitude())
			simpleTrack.getTrackPoints().add(trackPoint)
			
		}
}
