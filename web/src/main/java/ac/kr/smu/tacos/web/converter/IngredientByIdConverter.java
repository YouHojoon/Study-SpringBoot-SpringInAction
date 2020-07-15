package ac.kr.smu.tacos.web.converter;

import ac.kr.smu.tacos.domain.Ingredient;
import ac.kr.smu.tacos.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient convert(String source) {
        return ingredientRepository.findById(source).orElseThrow();
    }
}
