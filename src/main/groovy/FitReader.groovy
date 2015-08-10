
import java.awt.event.ItemEvent;
import java.util.Base64.Decoder;

import com.garmin.fit.Activity
import com.garmin.fit.ActivityMesg;
import com.garmin.fit.ActivityMesgListener;
import com.garmin.fit.Decode;
import com.garmin.fit.Event;
import com.garmin.fit.EventMesg;
import com.garmin.fit.EventMesgListener;
import com.garmin.fit.FileCapabilitiesMesg;
import com.garmin.fit.FileCapabilitiesMesgListener;
import com.garmin.fit.FileIdMesg;
import com.garmin.fit.FileIdMesgListener
import com.garmin.fit.MesgBroadcaster
import com.garmin.fit.RecordMesg;
import com.garmin.fit.RecordMesgListener;
import com.garmin.fit.SegmentFileMesg;
import com.garmin.fit.SegmentFileMesgListener
import com.garmin.fit.SegmentPointMesg;
import com.garmin.fit.SegmentPointMesgListener


class FitReader implements TrackReader{
	
	Decode decode = new Decode()
	File fitFile
	List<SegmentPointMesg>  points
	
	void read(File input, SimpleTrack simpleTrack) {
		
		def mesgBroadcaster = new MesgBroadcaster(decode);
		def listener = new FitMesgListener(simpleTrack: simpleTrack);
		def inp = new FileInputStream(input);
		if(!Decode.checkIntegrity(inp)){
			println "File integrity failed."
		}
		mesgBroadcaster.addListener((RecordMesgListener) listener);
		inp = new FileInputStream(input)
		mesgBroadcaster.run(inp)
	}

}
