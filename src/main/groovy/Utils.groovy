import java.text.SimpleDateFormat
import java.util.TimeZone


class Utils {
	
	static final String ZULU_TIME_FORMAT = "yyyy:MM:dd'T'hh:mm:ss'Z'"
	
	static double convertSemiCircles(int i){
		return i * (180 / (2 ** 31))
	}

	static String toZuluTimestamp(Calendar cal){
		final SimpleDateFormat sdf = new SimpleDateFormat(ZULU_TIME_FORMAT)
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"))
		sdf.format(cal.getTime())
	}
}
