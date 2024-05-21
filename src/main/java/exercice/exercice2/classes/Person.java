package exercice.exercice2.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private List<Address> addresses;
    private String email;
    private String phone;
}
