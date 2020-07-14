package ac.kr.smu.tacos.rest.resource;

import ac.kr.smu.tacos.domain.Ingredient;
import ac.kr.smu.tacos.rest.controller.IngredientController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import java.util.ArrayList;
import java.util.List;

public class IngredientResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler(){
        super(IngredientController.class, IngredientResource.class);
    }
    @Override
    protected IngredientResource instantiateModel(Ingredient entity) {
        return new IngredientResource(entity);
    }

    @Override
    public IngredientResource toModel(Ingredient entity) {
        return createModelWithId(entity.getId(), entity);
    }
    public List<IngredientResource> toModels(List<Ingredient> ingredients){
        List<IngredientResource> models= new ArrayList<>();
        ingredients.stream().forEach(i->models.add(toModel(i)));
        return models;
    }
}
