package exercice.exercice2.serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import lombok.RequiredArgsConstructor;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static exercice.Main.FILE_PATH;

@RequiredArgsConstructor
public abstract class JsonSerializable<C> {
    private final Class<C> className;

    public final C deserialize(String path) {
        Reader reader;

        try {
            reader = new FileReader(FILE_PATH + path);
            Gson gson = new GsonBuilder().create();
            C object = gson.fromJson(reader, className);

            reader.close();
            return object;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la lecture du fichier JSON");
        }
    }

    public abstract void serialize(JsonWriter writer, C object) throws IOException;
}