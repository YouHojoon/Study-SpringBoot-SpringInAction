package ac.kr.smu.tacos.rest.resource;

import ac.kr.smu.tacos.domain.Taco;
import ac.kr.smu.tacos.rest.controller.TacoRestController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler(){
        super(TacoRestController.class, TacoResource.class);

    }

    @Override
    protected TacoResource instantiateModel(Taco entity) {
        return new TacoResource(entity);
    }

    @Override
    public TacoResource toModel(Taco entity) {
        return createModelWithId(entity.getId(), entity);
    }
}
