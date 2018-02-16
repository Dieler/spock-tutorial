package spock.tut.testdata;

public class RegistryOffice {

    void registerMarriage(Person spouse1, Person spouse2) {
        spouse2.setLastName(spouse1.getLastName());
    }

    void registerMove(Person p, Address oldAddress, Address newAddress) {
        p.getAddresses().remove(oldAddress);
        p.getAddresses().add(newAddress);
    }
}
