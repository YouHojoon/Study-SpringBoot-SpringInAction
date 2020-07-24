package ac.kr.smu.tacos.messaging.service;

import ac.kr.smu.tacos.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitOrderMessagingService{
    private final RabbitTemplate rabbit;
    public void sendOrder(Order order){
        MessageConverter converter = rabbit.getMessageConverter();
        MessageProperties props = new MessageProperties();
        props.setHeader("X_ORDER_SOURCE", "WEB");
        Message message = converter.toMessage(order, props);
        rabbit.send("tacocloud.order", message);
    }
}
