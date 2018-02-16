package spock.tut.basics

import spock.lang.Specification

class SpecificationLifecycleSpec extends Specification {

    // JUnit: @BeforeClass
    def setupSpec() {}

    // JUnit: @Before
    def setup() {}

    // JUnit: @Test
    def "feature method 1"() {}

    // JUnit: @Test
    def "feature method 2"() {}

    // JUnit: @After
    def cleanup() {}

    // JUnit: @AfterClass
    def cleanupSpec() {}
}
