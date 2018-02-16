


import spock.tut.groovy.Address
import spock.tut.groovy.Person

def persons = [
        new Person(firstName: "Franz", lastName: "Meyer", addresses: [
                new Address(street: "Am Planetarium 10", city: "Jena", zip: "07743"),
                new Address(street: "Untergraben 1", city: "Weimar", zip: "99423")
        ]),
        new Person(firstName: "Mechthild", lastName: "Krause", addresses: [
                new Address(street: "Bachstraße 1", city: "Kahla", zip: "07768"),
                new Address(street: "Blumenstraße 5", city: "Erfurt", zip: "99092")
        ])
]

assert persons*.firstName == ["Franz", "Mechthild"]
assert persons.firstName == ["Franz", "Mechthild"]
assert persons*.firstName == persons.firstName

assert persons.firstName*.toUpperCase() == ["FRANZ", "MECHTHILD"]

assert persons*.addresses*.city == [["Jena", "Weimar"], ["Kahla", "Erfurt"]]
assert persons.addresses.city == [["Jena", "Weimar"], ["Kahla", "Erfurt"]]
assert persons*.addresses*.city == persons.addresses.city

assert persons.addresses.city.flatten() == ["Jena", "Weimar", "Kahla", "Erfurt"]
assert persons.addresses.city.flatten()*.toUpperCase() == ["JENA", "WEIMAR", "KAHLA", "ERFURT"]
assert persons.addresses.city.flatten()*.chars.flatten()*.toUpperCase() == [
        'J', 'E', 'N', 'A', 'W', 'E', 'I', 'M', 'A', 'R', 'K', 'A', 'H', 'L', 'A', 'E', 'R', 'F', 'U', 'R', 'T']
