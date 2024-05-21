package exercice.exercice1.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JsonData {
    private List<Truck> trucks;
}
