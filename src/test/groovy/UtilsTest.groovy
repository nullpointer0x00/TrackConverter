import spock.lang.*;


class UtilsTest extends Specification{
	
	def "test semi-circles converter"(){
		when:
			def deg = Utils.convertSemiCircles(536137868)
		then: 
			deg == 44.93855696171522
	}
	
	def "test zulu timestamp converter"(){
		when:
			def now = Calendar.getInstance()
			def result = Utils.toZuluTimestamp(now)
		then:
			result.length() == 20
			result.contains("T")
			result.contains("Z")
	}
}
