package ac.kr.smu.tacos.reactive.config;

import ac.kr.smu.tacos.reactive.domain.Ingredient;
import ac.kr.smu.tacos.reactive.domain.Taco;
import ac.kr.smu.tacos.reactive.repository.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Component
public class RouterFunctionConfig{
    @Autowired
    private TacoRepository tacoRepository;

    @Bean
    public RouterFunction<?> routerFunction(){
        return route(GET("/design/taco"), this::recents)
                .andRoute(POST("/design"), this::postTaco);
    }
    public Mono<ServerResponse> recents(ServerRequest request){
        tacoRepository.save(testTaco(2L)).subscribe();
        return ServerResponse.ok().body(tacoRepository.findAll().take(12), Taco.class);
    }
    public Mono<ServerResponse> postTaco(ServerRequest request) {
        Mono<Taco> taco = request.bodyToMono(Taco.class);
        Mono<Taco> savedTaco = tacoRepository.save(taco.block());
        return ServerResponse.created(URI.create("http://localhost:8080/design/taco/" + savedTaco.block().getId())).body(savedTaco, Taco.class);
    }
    private Taco testTaco(Long number){
        Taco taco = new Taco();
        taco.setId(UUID.randomUUID().toString());
        taco.setName("test");
        List<Ingredient> ingredients= new ArrayList<>();
        ingredients.add(new Ingredient("INGA", "Ingredient A", Ingredient.Type.WRAP));
        ingredients.add(new Ingredient("INGB", "Ingredient B", Ingredient.Type.PROTEIN));
        taco.setIngredients(ingredients);
        taco.setCreatedAt("2017-02-20");
        return taco;
    }
}
