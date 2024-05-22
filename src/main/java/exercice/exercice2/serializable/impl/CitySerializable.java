package exercice.exercice2.serializable.impl;

import com.google.gson.stream.JsonWriter;
import exercice.exercice2.classes.City;
import exercice.exercice2.serializable.JsonSerializable;

import java.io.IOException;

public class CitySerializable extends JsonSerializable<City> {
    public static CitySerializable citySerializable = new CitySerializable();

    private CitySerializable() {
        super(City.class);
    }

    public static CitySerializable getInstance() {
        if (citySerializable == null) {
            citySerializable = new CitySerializable();
        }
        return citySerializable;
    }

    @Override
    public void serialize(JsonWriter writer, City object) throws IOException {
        writer.name("ville");
        writer.beginObject();

        writer.name("nom").value(object.getName());
        writer.name("codePostal").value(object.getPostalCode());
        writer.name("pays").value(object.getCountry());

        writer.endObject();
    }
}
