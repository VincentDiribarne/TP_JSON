package exercice.exercice1.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trailer {
    private int weight;

    @Override
    public String toString() {
        return " \r \r - une remorque de " + weight + " tonnes";
    }
}