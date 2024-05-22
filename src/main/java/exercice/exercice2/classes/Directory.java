package exercice.exercice2.classes;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Directory {
    @SerializedName("personnes")
    private List<Person> persons = new ArrayList<>();
}
