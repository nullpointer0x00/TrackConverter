package com.beatnikstree.trackconverter.writer

import com.beatnikstree.trackconverter.domain.SimpleTrack
import com.beatnikstree.trackconverter.service.GoogleEleService
import com.beatnikstree.trackconverter.utils.Utils
import groovy.xml.MarkupBuilder


class GpxWriter implements TrackWriter{

	final String CREATOR_ATTR = "https://github.com/nullpointer0x00/TrackConverter"
	final String VERSION_ATTR = "1.1"
	final String XMLNS_ATTR = "http://www.topografix.com/GPX/1/1"
	final String XMLNS_XSI_ATTR = "http://www.w3.org/2001/XMLSchema-instance"
	final String XSI_SCHEMA_LOCATION_ATTR = "http://www.topografix.com/GPX/1/1"

	public void write(SimpleTrack simpleTrack) {
		def api = new GoogleEleService()
		def writer = new StringWriter()
		def xml = new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		xml.mkp.xmlDeclaration(version: "1.0", encoding: "utf-8")
		xml.gpx(creator: CREATOR_ATTR, version: VERSION_ATTR, xmlns: XMLNS_ATTR, "xmlns:xsi": XMLNS_XSI_ATTR, "xsi:schemaLocation": XSI_SCHEMA_LOCATION_ATTR) {
			metadata(){ time((simpleTrack.getTime() != null ? Utils.toZuluTimestamp(simpleTrack.getTime()) : "")) }
			xml.trk(){
				name(simpleTrack.getName())
				trkseg(){
					simpleTrack.getTrackPoints().each{
						def point = it
						trkpt(lat: point.getLat(), lon: point.getLon()){
							if(point.getAlt() != null){
								ele(point.getAlt())
							} else {
								ele(api.getLocationInfo(point.getLat(), point.getLon()))
							}
							time(Utils.toZuluTimestamp(point.getTimeStamp()))
						}
					}
				}
			}
		}
		println writer.toString()
	}
}
