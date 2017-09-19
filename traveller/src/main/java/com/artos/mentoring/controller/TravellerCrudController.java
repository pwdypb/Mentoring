package com.artos.mentoring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Gyula_Sajtos on 2017-09-19.
 */
@Controller
@RequestMapping("/traveller")
public class TravellerCrudController {

    private static final Logger LOG = Logger.getLogger(TravellerCrudController.class);

    @GetMapping
    public void createTraveller() {
        LOG.info("Get traveller");
    }

    @PostMapping
    public void getTraveller() {
        LOG.info("Create traveller");
    }

    @DeleteMapping
    public void deleteTraveller() {
        LOG.info("Delete traveller");
    }

}
