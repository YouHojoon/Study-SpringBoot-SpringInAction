package ac.kr.smu.tacos.reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection = "Taco")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taco implements Serializable {

    @Id
    private String id;


    private String  createdAt;

    private String name;
    private List<Ingredient> ingredients;
}