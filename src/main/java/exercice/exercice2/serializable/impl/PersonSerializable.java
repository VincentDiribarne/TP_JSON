package exercice.exercice2.serializable.impl;

import com.google.gson.stream.JsonWriter;
import exercice.exercice2.classes.Person;
import exercice.exercice2.serializable.JsonSerializable;

import java.io.IOException;

public class PersonSerializable extends JsonSerializable<Person> {
    public static PersonSerializable personSerializable = new PersonSerializable();

    private PersonSerializable() {
        super(Person.class);
    }

    public static PersonSerializable getInstance() {
        if (personSerializable == null) {
            personSerializable = new PersonSerializable();
        }
        return personSerializable;
    }

    @Override
    public void serialize(JsonWriter writer, Person person) throws IOException {
        writer.beginObject();

        writer.name("prénom").value(person.getFirstName());
        writer.name("nom").value(person.getLastName());
        writer.name("age").value(person.getAge());
        writer.name("adresses");

        writer.beginObject();
        person.getAddresses().forEach((key, value) -> {
            try {
                writer.name(key.getName());
                AddressSerializable.getInstance().serialize(writer, value);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writer.endObject();

        writer.name("email").value(person.getEmail());
        writer.name("téléphone").value(person.getPhone());

        writer.endObject();
    }
}
