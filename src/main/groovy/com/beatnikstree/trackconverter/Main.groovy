package com.beatnikstree.trackconverter

import com.beatnikstree.trackconverter.reader.FitReader
import com.beatnikstree.trackconverter.writer.GpxWriter

class Main {

	static void main(String[] args){
		def options = validateArguments(args)
		if (options?.c && options.c.equalsIgnoreCase("fitToGpx")) {
			if (validatePath(options.arguments()[0]) && validatePath(options.arguments()[1])) {
				convertFitToGpx(options.arguments()[0], "")
			}

		}
	}

	static OptionAccessor validateArguments(String[] args){
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
		return (valid ? options : null)
	}

	static void convertFitToGpx(String src, String dest){
		Converter converter = new Converter(reader:  new FitReader(), writer: new GpxWriter())
		converter.inputFile = new File(src)
		converter.convert()
	}
}
