package exercice.exercice2.classes;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@Builder
public class Person {
    @SerializedName("prénom")
    private String firstName;

    @SerializedName("nom")
    private String lastName;

    private int age;
    private HashMap<AddressType, Address> addresses;
    private String email;

    @SerializedName("téléphone")
    private String phone;
}
