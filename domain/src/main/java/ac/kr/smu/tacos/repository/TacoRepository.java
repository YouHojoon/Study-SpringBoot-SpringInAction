package ac.kr.smu.tacos.repository;

import ac.kr.smu.tacos.domain.Taco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TacoRepository extends JpaRepository<Taco, Long> {
}
