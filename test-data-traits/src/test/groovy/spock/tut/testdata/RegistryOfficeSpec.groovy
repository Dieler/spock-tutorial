package spock.tut.testdata

import spock.lang.Specification

class RegistryOfficeSpec extends Specification
        implements PersonTestData, AddressTestData {

    def "spouses should have the same last name after marriage"() {
        given: "two different persons"
            def spouse1 = person(lastName: "Müller")
            def spouse2 = person(lastName: "Krause")

        when: "the two persons register their marriage"
            new RegistryOffice().registerMarriage(spouse1, spouse2)

        then: "they have the same last name"
            spouse2.lastName == spouse1.lastName
    }

    def "should update address when person moves house"() {
        given: "a person who has moved house"
            def person = person(addresses: [address(street: "Sophienstraße 10")])
            def newAddress = address(street: "Am Planetarium 50")

        when: "the person registers their new address"
            new RegistryOffice().registerMove(person, person.addresses[0], newAddress)

        then: "the new address is included in the person's address list"
            newAddress in person.addresses

        and: "the old address has been removed from the person's address list"
            !(old(person.addresses[0]) in person.addresses)
    }
}
