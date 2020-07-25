package ac.kr.smu.tacos.reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(collection = "Ingredient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient implements Serializable {
    @Id
    private String id;

    private String name;

    private Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}