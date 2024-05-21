package exercice.exercice1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import exercice.exercice1.classes.JsonData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import static exercice.Main.FILE_PATH;

public class JSON {
    public void write() {
        try {
            JsonWriter writer = new JsonWriter(new FileWriter(FILE_PATH + "Exercice1.json"));
            writer.beginObject();
            writer.name("trucks");
            writer.beginArray();

            // Nouveau camion
            writer.beginObject();
            writer.name("brand").value("Mercedes");
            writer.name("model").value("Actros Actros");
            writer.endObject();

            // Nouveau camion
            writer.beginObject();
            writer.name("brand").value("Mercedes");
            writer.name("model").value("Fuso Center");

            //Remorques
            writer.name("trailers");
            writer.beginArray();

            writer.beginObject();
            writer.name("weight").value(42);
            writer.endObject();
            writer.beginObject();
            writer.name("weight").value(25);
            writer.endObject();

            // Fin des remorques
            writer.endArray();

            // Fin du camion
            writer.endObject();

            // Nouveau camion
            writer.beginObject();
            writer.name("brand").value("Ford");
            writer.name("model").value("Ford Cargo");
            writer.endObject();

            writer.endArray();
            writer.endObject();

            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier JSON");
        }
    }

    public void read() {
        Reader reader;

        try {
            reader = new FileReader(FILE_PATH + "Exercice1.json");
            Gson gson = new GsonBuilder().create();
            JsonData data = gson.fromJson(reader, JsonData.class);

            System.out.println("Liste des camions :");
            data.getTrucks().forEach(System.out::println);

            reader.close();
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier JSON");
        }
    }
}
