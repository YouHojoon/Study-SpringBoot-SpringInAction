package ac.kr.smu.tacos.reactive.repository;

import ac.kr.smu.tacos.reactive.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.Optional;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}