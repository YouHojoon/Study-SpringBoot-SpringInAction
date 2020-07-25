package ac.kr.smu.tacos.reactive;

import ac.kr.smu.tacos.reactive.domain.Ingredient;
import ac.kr.smu.tacos.reactive.domain.Taco;
import ac.kr.smu.tacos.reactive.repository.TacoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static ac.kr.smu.tacos.reactive.domain.Ingredient.Type;

@SpringBootTest
public class ReactiveTest {
    @Autowired
    private TacoRepository tacoRepository;
    @Test
    public void saveTaco(){
        Taco savedTaco = testTaco(2L);
        System.out.println(savedTaco);
        tacoRepository.save(savedTaco);
    }
    private Taco testTaco(Long number){
        Taco taco = new Taco();
        taco.setId(UUID.randomUUID().toString());
        taco.setName("test");
        List<Ingredient> ingredients= new ArrayList<>();
        ingredients.add(new Ingredient("INGA", "Ingredient A", Type.WRAP));
        ingredients.add(new Ingredient("INGB", "Ingredient B", Type.PROTEIN));
        taco.setIngredients(ingredients);
        taco.setCreatedAt("2017-02-20");
        return taco;
    }
}
