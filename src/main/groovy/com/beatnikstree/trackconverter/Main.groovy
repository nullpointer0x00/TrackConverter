package com.beatnikstree.trackconverter

class Main {


	static void main(String[] args){
		if(validateArguments(args)){
			//process
		}
	}

	static boolean validateArguments(String[] args){
		boolean valid = true
		CliBuilder cli = new CliBuilder(usage: "[options] [targets]")
		cli.with{
			c longOpt: 'convert', args: 1, argName: 'conversion', 'fitToGpx - Convert fit file to gpx'
		}
		OptionAccessor options = cli.parse(args)
		if(!options?.c || options.arguments().size() != 2 ){
			cli.usage()
			valid = false
		}
		return valid
	}

	static boolean validateSourcePath(String path){
		def file = new File(path)
		return file.exists() && file.exists() && file.readable()
	}
}
