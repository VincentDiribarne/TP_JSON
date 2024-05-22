package exercice.exercice2.builder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public abstract class Buildable<T> {
    @Getter
    private final Library library = Library.getInstance();
    private final Random random;

    public final int randomNumber(int max) {
        return random.nextInt(max);
    }

    public abstract T build();
}
