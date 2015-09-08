package com.beatnikstree.trackconverter

import com.beatnikstree.trackconverter.reader.FitReader
import com.beatnikstree.trackconverter.writer.GpxWriter

/**
 * Created by nullpointer0x00 on 9/6/15.
 */
class ConverterSpec extends  BaseSpec{

    def "convert fit to gpx test"(){
        setup:
        def fitFile = getTestResourceFile("test.FIT")
        when:
        Converter converter = new Converter(reader:  new FitReader(), writer: new GpxWriter())
        converter.inputFile = fitFile
        converter.convert()
        then:
        1 == 1
    }
}
