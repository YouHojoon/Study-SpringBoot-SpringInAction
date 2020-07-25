package ac.kr.smu.tacos.repository;

import ac.kr.smu.tacos.domain.Order;
import ac.kr.smu.tacos.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserOrderByPlaceAtDesc(User user, Pageable pageable);
}