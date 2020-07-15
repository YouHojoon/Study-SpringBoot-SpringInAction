package ac.kr.smu.tacos.rest.service;

import ac.kr.smu.tacos.domain.Taco;
import ac.kr.smu.tacos.repository.TacoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TacoService {
    private final TacoRepository tacoRepository;

    public Iterable<Taco> recentTacos(){
        PageRequest pageRequest= PageRequest.of(0,12, Sort.by("createdAt").descending());
        return tacoRepository.findAll(pageRequest).getContent();
    }

    public Taco findById(Long id){
        Optional<Taco> taco = tacoRepository.findById(id);
        if(taco.isPresent()){
            return taco.get();
        }
        return null;
    }

}
