package ac.kr.smu.tacos.web.controller;

import ac.kr.smu.tacos.domain.Ingredient;
import ac.kr.smu.tacos.domain.Order;
import ac.kr.smu.tacos.domain.Taco;
import ac.kr.smu.tacos.repository.IngredientRepository;
import ac.kr.smu.tacos.repository.TacoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ac.kr.smu.tacos.domain.Ingredient.Type;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@RequiredArgsConstructor
@SessionAttributes("order")
public class DesignTacoController {

    private final TacoRepository tacoRepository;
    private final IngredientRepository ingredientRepository;

    @ModelAttribute(name="order")
    public Order order(){
        return new Order();
    }
    @ModelAttribute(name="taco")
    public Taco taco(){
        return new Taco();
    }
    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "design";
    }
    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order){
       log.info(design.toString());
        if(errors.hasErrors()){
            return "design";
        }
        tacoRepository.save(design);
        order.addTaco(design);

        return "redirect:/orders/current";
    }
    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients.stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());
    }
}
