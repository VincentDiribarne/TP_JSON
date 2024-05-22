package exercice.exercice2.builder.impl;

import exercice.exercice2.builder.Buildable;
import exercice.exercice2.classes.Address;
import exercice.exercice2.classes.AddressType;
import exercice.exercice2.classes.Person;

import java.util.HashMap;
import java.util.Random;

public class PersonBuilder extends Buildable<Person> {
    public static PersonBuilder personBuilder;

    private PersonBuilder() {
        super(new Random());
    }

    public static PersonBuilder getInstance() {
        if (personBuilder == null) {
            personBuilder = new PersonBuilder();
        }

        return personBuilder;
    }

    private HashMap<AddressType, Address> getAddresses() {
        HashMap<AddressType, Address> addresses = new HashMap<>();
        AddressBuilder addressBuilder = AddressBuilder.getInstance();

        for (int i = 0; i < randomNumber(4); i++) {
            addresses.put(AddressType.values()[randomNumber(AddressType.values().length)], addressBuilder.build());
        }

        return addresses;
    }

    @Override
    public Person build() {
        String firstName = getLibrary().getFirstNames()[randomNumber(getLibrary().getFirstNames().length)];
        String lastName = getLibrary().getLastNames()[randomNumber(getLibrary().getLastNames().length)];

        String email = String.format("%s.%s@%s", firstName, lastName, getLibrary().getDomains()[randomNumber(getLibrary().getDomains().length)]);
        String phone = String.format("0%s %s %s %s %s", 1 + randomNumber(9), generatePhoneNumber(), generatePhoneNumber(), generatePhoneNumber(), generatePhoneNumber());

        return Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(randomNumber(48) + 1)
                .addresses(getAddresses())
                .email(email.toLowerCase())
                .phone(phone)
                .build();
    }

    private String generatePhoneNumber() {
        int phoneNumber = randomNumber(99);
        return phoneNumber < 10 ? "0" + phoneNumber : String.valueOf(phoneNumber);
    }
}
