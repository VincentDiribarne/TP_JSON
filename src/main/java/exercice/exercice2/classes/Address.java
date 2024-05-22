package exercice.exercice2.classes;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
    @SerializedName("numéro")
    private int number;

    @SerializedName("rue")
    private String street;

    @SerializedName("ville")
    private City city;
}
