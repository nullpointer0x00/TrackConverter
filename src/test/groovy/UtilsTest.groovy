import spock.lang.*;


class UtilsTest extends Specification{
	
	def "test semi-circles converter"(){
		when:
			def deg = Utils.convertSemiCircles(1)
		then: 
			deg > 0.0
	}
}
