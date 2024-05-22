package exercice;

import exercice.exercice1.JSON;
import exercice.exercice2.SecondJSON;
import exercice.exercice2.builder.impl.PersonBuilder;
import exercice.exercice2.classes.Directory;
import exercice.exercice2.classes.Person;

import java.util.Random;

public class Main {
    public static final String FILE_PATH = "src/main/resources/json/";

    public static void main(String[] args) {
        //Exercice 1
        JSON json = new JSON();
        json.write();
        System.out.println("Premier exercice : ");
        json.read();

        System.out.println("\nDeuxième exercice : ");

        //Exercice 2
        Random random = new Random();
        Directory directory = new Directory();

        for (int i = 0; i < random.nextInt(4, 15); i++) {
            Person person = PersonBuilder.getInstance().build();
            directory.getPersons().add(person);
        }

        SecondJSON<Directory> secondJSON = new SecondJSON<>(directory);

        Directory readJsonDirectory = secondJSON.start("directory.json");
        System.out.println("Il y a " + readJsonDirectory.getPersons().size() + " personnes dans le répertoire");
    }
}
