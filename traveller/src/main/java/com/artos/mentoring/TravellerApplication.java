package com.artos.mentoring;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravellerApplication extends SpringBootServletInitializer {

    private static final String TRAVELLER_CREATED_EXCHANGE = "traveller.created";

    public static void main(String[] args) {
		SpringApplication.run(TravellerApplication.class, args);
	}

	@Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

	@Bean
    public FanoutExchange travellerCreatedPublisher() {
	    return new FanoutExchange(TRAVELLER_CREATED_EXCHANGE);
    }

}
