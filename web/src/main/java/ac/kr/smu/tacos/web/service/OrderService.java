package ac.kr.smu.tacos.web.service;

import ac.kr.smu.tacos.domain.Order;
import ac.kr.smu.tacos.domain.User;
import ac.kr.smu.tacos.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    public void registerOrder(Order order, User user){
        order.setUser(user);
        orderRepository.save(order);
    }
}
