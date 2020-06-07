package ac.kr.smu.web.controller;

import ac.kr.smu.tacos.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@Slf4j
public class OrderController {
    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("order", new Order());
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, BindingResult bindingResult){
        log.info(order.toString());
        if(errors.hasErrors()){
            return "orderForm";
        }
        if(bindingResult.hasErrors()){
            return "orderForm";
        }
        return "redirect:/";
    }
}
