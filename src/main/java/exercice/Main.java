package exercice;

import exercice.exercice1.JSON;

public class Main {
    public static final String FILE_PATH = "src/main/resources/json/";

    public static void main(String[] args) {
        JSON json = new JSON();
        json.write();
        json.read();
    }
}
