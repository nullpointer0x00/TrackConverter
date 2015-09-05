import com.garmin.fit.Decode
import com.garmin.fit.MesgBroadcaster
import com.garmin.fit.RecordMesgListener
import com.garmin.fit.SegmentPointMesg

class GpxReader implements TrackReader {

    void read(File input, SimpleTrack simpleTrack) {
        def gpx = new XmlSlurper().parse(input)
        //simpleTrack.time  = gpx.metadata?.time?.text()
        simpleTrack.setName(gpx.trk?.name?.text().trim());
        gpx.trk.trkseg.trkpt.each {point ->
            def trackPoint = new SimpleTrackPoint(
                    lat: point.@lat.text() as Double,
                    lon: point.@lon.text() as Double,
                    alt: point.ele.text() as Double)
            simpleTrack.getTrackPoints().add(trackPoint)
        }
    }
}
