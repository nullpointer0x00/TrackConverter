package com.beatnikstree.trackconverter.reader

import com.beatnikstree.trackconverter.domain.SimpleTrack
import com.garmin.fit.Decode
import com.garmin.fit.MesgBroadcaster
import com.garmin.fit.RecordMesgListener
import com.garmin.fit.SegmentPointMesg

class FitReader implements TrackReader{
	
	Decode decode = new Decode()
	File fitFile
	List<SegmentPointMesg>  points
	
	void read(File input, SimpleTrack simpleTrack) {
		
		def mesgBroadcaster = new MesgBroadcaster(decode);
		def listener = new FitMesgListener(simpleTrack: simpleTrack);
		def inStream = new FileInputStream(input);
		if(!Decode.checkIntegrity(inStream)){
			throw new Exception("File integrity check failed")
		}
		mesgBroadcaster.addListener((RecordMesgListener) listener);
		inStream = new FileInputStream(input)
		mesgBroadcaster.run(inStream)
	}

}
