package ac.kr.smu.tacos.repository;

import ac.kr.smu.tacos.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
