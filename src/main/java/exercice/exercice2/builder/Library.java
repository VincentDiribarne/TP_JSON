package exercice.exercice2.builder;

import exercice.exercice2.classes.City;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public static Library library;

    private Library() {
    }

    public static Library getInstance() {
        if (library == null) {
            library = new Library();
        }

        return library;
    }

    public List<City> getCities() {
        List<City> cities = new ArrayList<>();

        cities.add(buildCity("Paris", "75000"));
        cities.add(buildCity("Lyon", "69000"));
        cities.add(buildCity("Marseille", "13000"));
        cities.add(buildCity("Toulouse", "31000"));
        cities.add(buildCity("Nice", "06000"));
        cities.add(buildCity("Nantes", "44000"));
        cities.add(buildCity("Strasbourg", "67000"));
        cities.add(buildCity("Montpellier", "34000"));
        cities.add(buildCity("Bordeaux", "33000"));

        return cities;
    }

    public String[] getStreets() {
        return new String[]{
                "Rue du Faubourg Saint-Denis",
                "Rue du Faubourg Saint-Martin",
                "Rue de la Roquette",
                "Rue de la République",
                "Rue de la Convention",
                "Rue de Rivoli",
                "Rue de la République",
                "Rue du Faubourg Saint-Honoré",
                "Rue de la Roquette",
                "Rue de la Convention",
                "Rue de la Croix-Nivert",
                "Rue de la Pompe"
        };
    }

    public String[] getFirstNames() {
        return new String[]{
                "Jean",
                "Pierre",
                "Paul",
                "Jacques",
                "Nicolas",
                "François",
                "Michel",
                "Louis",
                "Henri",
                "Philippe",
                "André",
                "Charles"
        };
    }

    public String[] getLastNames() {
        return new String[]{
                "Martin",
                "Bernard",
                "Thomas",
                "Petit",
                "Robert",
                "Richard",
                "Durand",
                "Dubois",
                "Moreau",
                "Laurent",
                "Simon",
                "Lefebvre"
        };
    }

    public String[] getDomains() {
        return new String[]{
                "gmail.com",
                "yahoo.fr",
                "outlook.com",
                "orange.fr",
                "sfr.fr",
                "free.fr",
                "laposte.net",
        };
    }

    private City buildCity(String name, String postalCode) {
        return City.builder()
                .name(name)
                .postalCode(postalCode)
                .country("France")
                .build();
    }
}
