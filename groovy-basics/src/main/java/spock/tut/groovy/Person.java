package spock.tut.groovy;

import java.util.List;

import lombok.Data;

@Data
public class Person {
    private String firstName;
    private String lastName;
    private List<Address> addresses;
}
