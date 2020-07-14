package ac.kr.smu.tacos.rest.resource;


import ac.kr.smu.tacos.domain.Ingredient;
import ac.kr.smu.tacos.domain.Ingredient.Type;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class IngredientResource extends RepresentationModel<IngredientResource> {
    private String name;
    private Type type;
    public IngredientResource(Ingredient ingredient){
        this.name=ingredient.getName();
        this.type=ingredient.getType();
    }
}
