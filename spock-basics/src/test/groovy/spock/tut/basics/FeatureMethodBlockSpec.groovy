package spock.tut.basics

import spock.lang.Specification

class FeatureMethodBlockSpec extends Specification {

    def "should compute sum of integers"() {
        given:
            def x = 1
            def y = 2

        when:
            def result = x + y

        then:
            result == 3
    }

    def "newly-created list should be empty"() {
        given:
            def l = new ArrayList()

        expect:
            l.size() == 0
    }

    def "new list should be empty"() {
        expect:
            // new ArrayList().size() == 0
            !new ArrayList()
    }
}
