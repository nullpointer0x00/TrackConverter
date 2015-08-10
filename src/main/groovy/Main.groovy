
class Main {

	public static void main(String[] args){
		File file = new File("/home/nullpointer0x00/workspace-groovy/TrackingConverter/src/test1.FIT")
		def reader = new FitReader(fitFile: file)
		reader.read(file)
	}
}
