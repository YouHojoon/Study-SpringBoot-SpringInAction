package ac.kr.smu.tacos.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
@SpringBootTest
public class ReactiveTest {
    @Test
    public void test() {
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        fruitFlux.subscribe(f-> System.out.println("Here's some fruit : "+ f));
    }
}
