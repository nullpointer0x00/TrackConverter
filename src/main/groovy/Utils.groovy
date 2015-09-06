import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormat
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormatter


class Utils {
	
	static final String ZULU_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
	
	static double convertSemiCircles(int i){
		return i * (180 / (2 ** 31))
	}

	static double degreeToRadian(double degree){
		return (Math.PI/180) * degree
	}

	static DateTime convertZuluTimestamp(String zuluTimestamp){
		DateTimeFormatter dtf = DateTimeFormat.forPattern(ZULU_TIME_FORMAT);
		dtf.withZoneUTC().parseDateTime(zuluTimestamp);
	}

	static String toZuluTimestamp(def time){
		DateTime dateTime
		if(time instanceof Date){
			dateTime = new DateTime(time as Date)
		} else if (time instanceof Calendar){
			dateTime = new DateTime(time as Calendar)
		} else if (time instanceof DateTime){
			dateTime = time
		} else {
			return null
		}
		dateTime.withZone(DateTimeZone.UTC).toString(ZULU_TIME_FORMAT)
	}

	static Double distanceInMi(double lat1, double lon1, double lat2, double lon2){
		return 0.62137d * distanceInKm(lat1, lon1, lat2, lon2)
	}

	static Double distanceInKm(double lat1, double lon1, double lat2, double lon2){
		int  R = 6371
		double dLat = degreeToRadian(lat2 - lat1)
		double dLon = degreeToRadian(lon2 - lon2)
		double a = Math.cos(degreeToRadian(lat1)) * Math.cos(degreeToRadian(lat2))
		a = a * Math.sin(dLon/2) * Math.sin(dLon/2)
		a = a + Math.sin(dLat/2) * Math.sin(dLat/2)
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a))
		R * c
	}
}
