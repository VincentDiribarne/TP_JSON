package exercice.exercice2.classes;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class City {
    @SerializedName("nom")
    private String name;

    @SerializedName("codePostal")
    private String postalCode;

    @SerializedName("pays")
    private String country;
}
