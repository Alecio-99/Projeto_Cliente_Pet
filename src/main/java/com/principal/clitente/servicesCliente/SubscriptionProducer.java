package com.principal.clitente.servicesCliente;

import com.principal.clitente.DTO.ServiceSubscriptionEventDTO;
import com.principal.clitente.conf.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubscriptionProducer {

    private final RabbitTemplate rabbitTemplate;

    public SubscriptionProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendSubscriptionEvent(ServiceSubscriptionEventDTO event){
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE,
                RabbitConfig.ROUTING_KEY,
                event
        );
        log.info("Envento enviado: " + event);
    }

}
