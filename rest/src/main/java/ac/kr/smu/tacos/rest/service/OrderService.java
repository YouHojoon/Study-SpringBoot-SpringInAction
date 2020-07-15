package ac.kr.smu.tacos.rest.service;

import ac.kr.smu.tacos.domain.Order;
import ac.kr.smu.tacos.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public Order save(Order order){
        return orderRepository.save(order);
    }
    public void delete(Long id){
        orderRepository.deleteById(id);
    }
}
