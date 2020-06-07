package ac.kr.smu.tacos.repository;

import ac.kr.smu.tacos.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
