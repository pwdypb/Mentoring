package com.artos.trek;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrekApplication {

	private static final String TRAVELLER_CREATED_EXCHANGE = "traveller.created";

	public static void main(String[] args) {
		SpringApplication.run(TrekApplication.class, args);
	}

	@Bean
	public FanoutExchange travellerCreatedPublisher() {
		return new FanoutExchange(TRAVELLER_CREATED_EXCHANGE);
	}

	@Bean
	public AnonymousQueue notificationQueue() {
		return new AnonymousQueue();
	}

	@Bean
	public Binding bindingToTravellerCreation(FanoutExchange travellerExchange, Queue notificationQueue) {
		return BindingBuilder.bind(notificationQueue).to(travellerExchange);
	}

}
