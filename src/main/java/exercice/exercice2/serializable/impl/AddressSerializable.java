package exercice.exercice2.serializable.impl;

import com.google.gson.stream.JsonWriter;
import exercice.exercice2.classes.Address;
import exercice.exercice2.serializable.JsonSerializable;

import java.io.IOException;

public class AddressSerializable extends JsonSerializable<Address> {
    public static AddressSerializable addressSerializable = new AddressSerializable();

    private AddressSerializable() {
        super(Address.class);
    }

    public static AddressSerializable getInstance() {
        if (addressSerializable == null) {
            addressSerializable = new AddressSerializable();
        }
        return addressSerializable;
    }

    @Override
    public void serialize(JsonWriter writer, Address address) throws IOException {
        writer.beginObject();

        writer.name("numéro").value(address.getNumber());
        writer.name("rue").value(address.getStreet());

        CitySerializable.getInstance().serialize(writer, address.getCity());

        writer.endObject();
    }
}