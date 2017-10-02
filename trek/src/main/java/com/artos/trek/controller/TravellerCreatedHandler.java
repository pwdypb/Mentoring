package com.artos.trek.controller;

import org.jboss.logging.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Gyula_Sajtos on 2017-09-19.
 */
@Component
public class TravellerCreatedHandler {

    private static final Logger LOG = Logger.getLogger(TravellerCreatedHandler.class);

    @RabbitListener(queues = "#{notificationQueue.name}")
    public void onTravellerCreated() {
        LOG.info("Received traveller created event.");
    }

}
