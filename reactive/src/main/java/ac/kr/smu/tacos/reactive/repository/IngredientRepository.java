package ac.kr.smu.tacos.reactive.repository;

import ac.kr.smu.tacos.reactive.domain.Ingredient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface IngredientRepository extends ReactiveMongoRepository<Ingredient, String> {

}