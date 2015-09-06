package com.beatnikstree.trackconverter

import spock.lang.Specification

class BaseSpec extends Specification {

    File getTestResourceFile(String name){
        def classLoader = this.getClass().getClassLoader()
        def path = classLoader.getResource(name).getFile()
        new File(path)
    }

}
