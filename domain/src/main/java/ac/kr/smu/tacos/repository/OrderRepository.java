package ac.kr.smu.tacos.repository;

import ac.kr.smu.tacos.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
