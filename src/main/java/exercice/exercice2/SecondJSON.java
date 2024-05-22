package exercice.exercice2;

import com.google.gson.stream.JsonWriter;
import exercice.exercice2.serializable.impl.AddressSerializable;
import exercice.exercice2.serializable.impl.DirectorySerializable;
import exercice.exercice2.serializable.JsonSerializable;
import exercice.exercice2.serializable.impl.PersonSerializable;
import lombok.RequiredArgsConstructor;

import java.io.FileWriter;

import static exercice.Main.FILE_PATH;

@RequiredArgsConstructor
public class SecondJSON<T> {
    private final T object;

    public T start(String path) {
        write(path);
        T object = read(path);

        System.out.println("Fichier JSON créé et lu avec succès");
        return object;
    }


    private void write(String path) {
        try {
            JsonWriter writer = new JsonWriter(new FileWriter(FILE_PATH + path));

            if (getSerializable() != null) {
                getSerializable().serialize(writer, object);
                writer.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'écriture du fichier JSON");
        }
    }

    private T read(String path) {
        JsonSerializable<T> serializable = getSerializable();
        return serializable != null ? serializable.deserialize(path) : null;
    }

    @SuppressWarnings("unchecked")
    private JsonSerializable<T> getSerializable() {
        return switch (object.getClass().getName()) {
            case "exercice.exercice2.classes.Person" -> (JsonSerializable<T>) PersonSerializable.getInstance();
            case "exercice.exercice2.classes.Address" -> (JsonSerializable<T>) AddressSerializable.getInstance();
            case "exercice.exercice2.classes.Directory" -> (JsonSerializable<T>) DirectorySerializable.getInstance();
            default -> throw new RuntimeException("Classe non reconnue");
        };
    }
}
