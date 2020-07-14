package ac.kr.smu.tacos.web.service;

import ac.kr.smu.tacos.domain.Order;
import ac.kr.smu.tacos.domain.User;
import ac.kr.smu.tacos.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    public void registerOrder(Order order, User user){
        order.setUser(user);
        orderRepository.save(order);
    }

    public List<Order> findByUserOrderByPlacedAtDesc(User user){
        Pageable pageable= PageRequest.of(0,20);
        return orderRepository.findByUserOrderByPlaceAtDesc(user,pageable);
    }

}
