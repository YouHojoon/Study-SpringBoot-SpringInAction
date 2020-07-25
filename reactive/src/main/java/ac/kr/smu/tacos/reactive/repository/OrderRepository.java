package ac.kr.smu.tacos.reactive.repository;

import ac.kr.smu.tacos.reactive.domain.Order;
import ac.kr.smu.tacos.reactive.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;


public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
}