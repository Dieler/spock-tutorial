package spock.tut.testdata

import spock.lang.Specification

class AddressTestDataSpec extends Specification
        implements AddressTestData {

    @Override
    Map<String, Object> getAddressProperties() {
        defaultAddressProperties << [street: "Leutragraben 1-2"]
    }

    def "should not overwrite any address property"() {
        expect:
            with(address()) {
                street: addressProperties.street
                city: defaultAddressProperties.city
                zip: defaultAddressProperties.zip
            }
    }

    def "should overwrite street property"() {
        given:
            def street = "Sophienstraße 1"
            def address = address(street: street)

        expect:
            with(address) {
                street: street
                city: defaultAddressProperties.city
                zip: defaultAddressProperties.zip
            }
    }

    def "should overwrite city property"() {
        given:
            def city = "Weimar"
            def address = address(city: city)

        expect:
            with(address) {
                street: addressProperties.street
                city: city
                zip: defaultAddressProperties.zip
            }
    }

    def "should overwrite zip property"() {
        given:
            def zip = "07745"
            def address = address(zip: zip)

        expect:
            with(address) {
                street: addressProperties.street
                city: defaultAddressProperties.city
                zip: zip
            }
    }
}
