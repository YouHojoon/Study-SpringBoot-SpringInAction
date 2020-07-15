package ac.kr.smu.tacos.rest.controller;

import ac.kr.smu.tacos.domain.Order;
import ac.kr.smu.tacos.domain.Taco;
import ac.kr.smu.tacos.rest.resource.TacoResource;
import ac.kr.smu.tacos.rest.resource.TacoResourceAssembler;
import ac.kr.smu.tacos.rest.service.OrderService;
import ac.kr.smu.tacos.rest.service.TacoService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TacoRestController {
    private final TacoService tacoService;
    private final OrderService orderService;
    private final EntityLinks entityLinks;

    @GetMapping("/recent")
    public CollectionModel<TacoResource> recentTacos(){
        CollectionModel<TacoResource> recentResources= new TacoResourceAssembler().toCollectionModel(tacoService.recentTacos());
        recentResources.add(linkTo(methodOn(TacoRestController.class).recentTacos()).withRel("recents"));
        return recentResources;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id){
        Taco taco = tacoService.findById(id);
        if(taco==null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(taco,HttpStatus.OK);
    }
    @PutMapping("/{orderId}")
    public Order putOrder(@RequestBody Order order){
        return orderService.save(order);
    }
    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        orderService.delete(orderId);
    }
}
