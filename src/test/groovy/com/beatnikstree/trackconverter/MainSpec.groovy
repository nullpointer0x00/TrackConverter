package com.beatnikstree.trackconverter

import spock.lang.Specification
import spock.lang.Unroll

class MainSpec extends Specification {

    @Unroll
    def "validate command line args: #name"() {
        setup:
        def result = Main.validateArguments(arguments)
        expect:
        (result instanceof OptionAccessor) == expected
        where:
        name                             | arguments                                     | expected
//        "null"                           | null                                          | false
//        "empty"                          | ""                                            | false
//        "non-sense"                      | "HELLO"                                       | false
//        "correct-ish-0 missing src dest" | ["-c", "fitToGpx"] as String[]                | false
//        "correct-ish-1 missing dest"     | ["-c", "fitToGpx", "src"] as String[]         | false
//        "correct-ish-2 incorrect flag"   | ["-d", "fitToGpx", "src", "dest"] as String[] | false
        "correct syntax"                 | ['-c', 'fitToGpx', 'src', 'dest'] as String[] |  true
    }

//    def "validate src path"(){
//        setup:
//        def result = com.beatnikstree.trackconverter.Main.validateSourcePath(arguments)
//        expect:
//        result = expected
//        where:
//        name | arguments | expected
//        "invalid source path" | (String[])|false
//    }
}
