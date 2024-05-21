package exercice.exercice2;

import com.google.gson.stream.JsonWriter;

public interface JsonSerializable<T> {
    T deserialize();

    void serialize(T obj);

    void serialize(JsonWriter writer, T obj);
}