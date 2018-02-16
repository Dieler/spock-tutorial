package spock.tut.testdata;

import java.util.List;

import lombok.Data;

@Data
public class Person {
    private String firstName;
    private String lastName;
    private String zip;
    private List<Address> addresses;
}
