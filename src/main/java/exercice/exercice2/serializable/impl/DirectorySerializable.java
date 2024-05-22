package exercice.exercice2.serializable.impl;

import com.google.gson.stream.JsonWriter;
import exercice.exercice2.classes.Directory;
import exercice.exercice2.classes.Person;
import exercice.exercice2.serializable.JsonSerializable;

import java.io.IOException;

public class DirectorySerializable extends JsonSerializable<Directory> {
    public static DirectorySerializable directorySerializable = new DirectorySerializable();

    private DirectorySerializable() {
        super(Directory.class);
    }

    public static DirectorySerializable getInstance() {
        if (directorySerializable == null) {
            directorySerializable = new DirectorySerializable();
        }
        return directorySerializable;
    }

    @Override
    public void serialize(JsonWriter writer, Directory directory) throws IOException {
        writer.beginObject();
        writer.name("personnes");
        writer.beginArray();

        for (Person person : directory.getPersons()) {
            PersonSerializable.getInstance().serialize(writer, person);
        }

        writer.endArray();
        writer.endObject();
    }
}
