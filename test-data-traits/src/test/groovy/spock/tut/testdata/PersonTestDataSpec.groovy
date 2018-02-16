package spock.tut.testdata

import spock.lang.Specification

class PersonTestDataSpec extends Specification
        implements PersonTestData, AddressTestData {

    @Override
    Map<String, Object> getPersonProperties() {
        defaultPersonProperties << [
                addresses: [address()]
        ]
    }

    def "address of default person properties matches default address properties"() {
        expect:
            with(personProperties.addresses[0] as Address) {
                street == addressProperties.street
                city == addressProperties.city
                zip == addressProperties.zip
            }
    }

    def "should overwrite last name of person"() {
        given:
            def p = person(lastName: "Meyer")

        expect:
            p.firstName == personProperties.firstName
            p.lastName == "Meyer"
            p.addresses == personProperties.addresses
    }

    def "should overwrite first name of person"() {
        given:
            def p = person(firstName: "Hannes")

        expect:
            p.firstName == "Hannes"
            p.lastName == personProperties.lastName
            p.addresses == personProperties.addresses
    }

    def "should overwrite addresses of person"() {
        given:
            def addresses = [address(street: "Leutragraben 1-2")]
            def p = person(addresses: addresses)

        expect:
            p.firstName == personProperties.firstName
            p.lastName == personProperties.lastName
            p.addresses == addresses
    }

    def "should not overwrite any property of person"() {
        expect:
            with(person()) {
                firstName == personProperties.firstName
                lastName == personProperties.lastName
                addresses == personProperties.addresses
            }
    }
}
