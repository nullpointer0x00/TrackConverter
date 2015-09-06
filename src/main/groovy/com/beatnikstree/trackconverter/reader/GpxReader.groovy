package com.beatnikstree.trackconverter.reader

import com.beatnikstree.trackconverter.domain.SimpleTrack
import com.beatnikstree.trackconverter.domain.SimpleTrackPoint
import com.beatnikstree.trackconverter.utils.Utils

class GpxReader implements TrackReader {

    void read(File input, SimpleTrack simpleTrack) {
        def gpx = new XmlSlurper().parse(input)
        //simpleTrack.time  = gpx.metadata?.time?.text()
        simpleTrack.setName(gpx.trk?.name?.text().trim());
        gpx.trk.trkseg.trkpt.each {point ->
            def trackPoint = new SimpleTrackPoint(
                    lat: point.@lat.text() as Double,
                    lon: point.@lon.text() as Double,
                    timeStamp: Utils.convertZuluTimestamp(point.time.text()),
                    alt: point.ele.text() as Double)
            simpleTrack.getTrackPoints().add(trackPoint)
        }
    }
}
