package ac.kr.smu.tacos.web.service;

import ac.kr.smu.tacos.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class listener {

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(Order order){
        log.info(order.toString());
    }
}
