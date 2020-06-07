package ac.kr.smu.tacos.web.controller;

import ac.kr.smu.tacos.domain.Order;
import ac.kr.smu.tacos.domain.User;
import ac.kr.smu.tacos.repository.OrderRepository;
import ac.kr.smu.tacos.web.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    private final OrderService orderservice;
    @GetMapping("/current")
    public String orderForm(@AuthenticationPrincipal User user, @ModelAttribute Order order){
        if(order.getDeliveryCity()==null)
            order.setDeliveryCity(user.getCity());

        if(order.getDeliveryName()==null)
            order.setDeliveryName(user.getFullName());
        if(order.getDeliveryState()==null)
            order.setDeliveryState(user.getState());
        if(order.getDeliveryStreet()==null)
            order.setDeliveryStreet(user.getStreet());
        if(order.getDeliveryZip()==null)
            order.setDeliveryZip(user.getZip());
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid Order order, @AuthenticationPrincipal User user,
                               Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderForm";
        }
        orderservice.registerOrder(order,user);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
