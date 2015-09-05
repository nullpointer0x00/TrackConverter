import groovy.transform.Canonical

@Canonical
class SimpleTrackPoint {
	Calendar timeStamp
	Double lat
	Double lon
	Double alt
}
