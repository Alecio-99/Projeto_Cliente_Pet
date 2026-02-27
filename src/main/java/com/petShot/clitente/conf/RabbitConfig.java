package com.petShot.clitente.conf;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE = "service.exchange";
    public static final String ROUTING_KEY = "service.subscription";

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }
}
