package exercice.exercice1.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Truck {
    private String brand;
    private String model;
    private List<Trailer> trailers;

    @Override
    public String toString() {
        return "\r - Il s'agit d'un camion de la marque " + brand + " et de modèle " + model +
                (trailers != null ? " avec : \n" + trailers.stream().map(Trailer::toString).collect(Collectors.joining("\n")) : ".");
    }
}
