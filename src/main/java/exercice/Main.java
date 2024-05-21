package exercice;

import exercice.exercice1.JSON;
import exercice.exercice2.SecondJSON;

public class Main {
    public static final String FILE_PATH = "src/main/resources/json/";

    public static void main(String[] args) {
        //Exercice 1
        JSON json = new JSON();
        json.write();
        json.read();

        //Exercice 2
        SecondJSON secondJSON = new SecondJSON();
    }
}
