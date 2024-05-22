package exercice.exercice2.builder.impl;

import exercice.exercice2.builder.Buildable;
import exercice.exercice2.classes.Address;

import java.util.Random;

public class AddressBuilder extends Buildable<Address> {
    public static AddressBuilder addressBuilder;

    private AddressBuilder() {
        super(new Random());
    }

    public static AddressBuilder getInstance() {
        if (addressBuilder == null) {
            addressBuilder = new AddressBuilder();
        }

        return addressBuilder;
    }

    @Override
    public Address build() {
        return Address.builder()
                .number(randomNumber(100) + 1)
                .street(getLibrary().getStreets()[randomNumber(getLibrary().getStreets().length)])
                .city(getLibrary().getCities().get(randomNumber(getLibrary().getCities().size())))
                .build();
    }
}
