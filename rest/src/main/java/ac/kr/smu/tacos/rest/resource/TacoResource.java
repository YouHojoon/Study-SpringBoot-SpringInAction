package ac.kr.smu.tacos.rest.resource;

import ac.kr.smu.tacos.domain.Taco;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Date;
import java.util.List;

@Getter
@Relation(collectionRelation = "tacos")
public class TacoResource extends RepresentationModel<TacoResource>{
    private final String name;
    private final Date createdAt;
    private final List<IngredientResource> ingredients;

    public TacoResource(Taco taco){
        this.name = taco.getName();
        this.createdAt=taco.getCreatedAt();
        this.ingredients=new IngredientResourceAssembler().toModels(taco.getIngredients());
    }
}
