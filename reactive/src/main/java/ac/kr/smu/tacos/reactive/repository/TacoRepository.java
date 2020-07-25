package ac.kr.smu.tacos.reactive.repository;

import ac.kr.smu.tacos.reactive.domain.Taco;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends ReactiveMongoRepository<Taco, String> {
}