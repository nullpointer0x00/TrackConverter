package com.beatnikstree.trackconverter.writer

import com.beatnikstree.trackconverter.domain.SimpleTrack
import com.beatnikstree.trackconverter.domain.SimpleTrackPoint
import com.beatnikstree.trackconverter.writer.GpxWriter
import spock.lang.Specification;
import org.joda.time.DateTime


class GpxWriterSpec extends Specification{

	def "test gpx writter expect null pointer"(){
		when:
			def gpxWriter = new GpxWriter()
			gpxWriter.write()
		then:
			thrown(NullPointerException)
				
	}
	
	def "test gpx writter empty list"(){
		when:
			def simpleTrack = new SimpleTrack(trackPoints: new LinkedList<SimpleTrackPoint>())
			def gpxWriter = new GpxWriter(simpleTrack: simpleTrack)
			gpxWriter.write()
		then:
			1 == 1
	}
	
	def "test gpx writter 1 item list"(){
		when:
			def simpleTrack = new SimpleTrack(trackPoints: new LinkedList<SimpleTrackPoint>())
			def now = DateTime.now()
			def track = new SimpleTrackPoint(alt: null, lat: 1.0, lon: -1.0, timeStamp: now)
			simpleTrack.getTrackPoints().add(track)
			def gpxWriter = new GpxWriter(simpleTrack: simpleTrack)
			gpxWriter.write()
		then:
			1 == 1
	}
	
	def "test gpx writter 2 item list"(){
		when:
			def simpleTrack = new SimpleTrack(trackPoints: new LinkedList<SimpleTrackPoint>())
			def now = DateTime.now()
			def track = new SimpleTrackPoint(alt: null, lat: 1.0, lon: -1.0, timeStamp: now)
			simpleTrack.getTrackPoints().add(track)
			now = DateTime.now()
			track = new SimpleTrackPoint(alt: null, lat: 2.0, lon: -2.0, timeStamp: now)
			simpleTrack.getTrackPoints().add(track)
			def gpxWriter = new GpxWriter(simpleTrack: simpleTrack)
			gpxWriter.write()
		then:
			1 == 1
	}
}
