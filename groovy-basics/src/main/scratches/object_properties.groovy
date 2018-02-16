import spock.tut.groovy.Address
import spock.tut.groovy.Person
import spock.tut.groovy.PrivatePerson



def p = new Person(firstName: "Franz", lastName: "Müller")

assert p.firstName == "Franz"
assert p.lastName == "Müller"

p.lastName = "Meyer"
assert p.lastName == "Meyer"

// null check
assert !p.addresses

p.addresses = [
    addressData(street: "Am Planetarium", city: "Jena", zip: "07743"),
    addressData(street: "Am Markt", city: "Weimar", zip: "89890")
].collect {
    new Address(street: it.get(0), city: it.get(1), zip: it.get(2))
}

Tuple addressData(Map<String, Object> data) {
    new Tuple(data.street, data.city, data.zip)
}

assert p.addresses.city == ["Jena", "Weimar"]
assert p.addresses*.zip == ["07743", "89890"]

def p2 = new PrivatePerson()

assert !p2.privateAttribute

p2.privateAttribute = true

assert p2.privateAttribute

// won't compile
// p2.privateFinalFlag = true

