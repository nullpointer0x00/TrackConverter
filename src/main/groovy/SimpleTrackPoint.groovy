import groovy.transform.Canonical
import org.joda.time.DateTime
@Canonical
class SimpleTrackPoint {
	DateTime timeStamp
	Double lat
	Double lon
	Double alt
}
