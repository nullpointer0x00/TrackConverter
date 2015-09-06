package com.beatnikstree.trackconverter.reader

import com.beatnikstree.trackconverter.domain.SimpleTrack

interface TrackReader {
	
	void read(File input, SimpleTrack simpleTrack)
}
