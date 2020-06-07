package ac.kr.smu.tacos.web.controller;

import ac.kr.smu.tacos.domain.Order;
import ac.kr.smu.tacos.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@Slf4j
@SessionAttributes("order")
@RequiredArgsConstructor
public class OrderController {
    private OrderRepository orderRepository;
    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus){
        log.info(order.toString());
        if(errors.hasErrors()){
            return "orderForm";
        }
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
