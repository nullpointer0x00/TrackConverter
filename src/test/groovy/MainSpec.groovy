import spock.lang.Specification
import spock.lang.Unroll

class MainSpec extends Specification {

    @Unroll
    def "validate command line args: #name"() {
        setup:
        def result = Main.validateArguments(arguments)
        expect:
        result == expected
        where:
        name                                      | arguments | expected
        "null"                                    | null      | false
        "empty"                                   | ""        | false
        "non-sense"                               | "HELLO"   | false
        "correct-ish-0 missing src dest"          | (String[]) ["-c", "fitToGpx"] | false
        "correct-ish-1 missing dest"              | (String[]) ["-c", "fitToGpx", "src"] | false
        "correct-ish-2 incorrect flag"            | (String[]) ["-d", "fitToGpx", "src", "dest"] | false
        "correct syntax"                          | (String[]) ['-c', 'fitToGpx', 'src', 'dest'] | true
    }
}
