package com.beatnikstree.trackconverter

import com.beatnikstree.trackconverter.domain.SimpleTrack
import com.beatnikstree.trackconverter.reader.TrackReader
import com.beatnikstree.trackconverter.writer.TrackWriter

class Converter {

	File inputFile
	TrackReader reader
	TrackWriter writer
	SimpleTrack simpleTrack

	void convert(){
		if(reader == null){
			println "reader cannot be null"
			return
		}

		if(writer == null){
			println "writer cannot be null"
			return
		}

		simpleTrack = new SimpleTrack(trackPoints: new LinkedList<SimpleTrack>())


		reader.read(inputFile, simpleTrack)
		writer.write()
	}

}
