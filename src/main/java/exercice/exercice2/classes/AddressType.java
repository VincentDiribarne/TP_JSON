package exercice.exercice2.classes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AddressType {
    HOME("Domicile"),
    WORK("Travail"),
    OTHER("Autre");

    private final String name;
}
