package com.artos.mentoring.controller;

import com.artos.mentoring.model.Traveler;
import com.artos.mentoring.service.TravellerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


/**
 * Created by Gyula_Sajtos on 2017-09-19.
 */
@Controller
@RequestMapping("/traveller")
public class TravellerCrudController {

    private static final Logger LOG = Logger.getLogger(TravellerCrudController.class);

    @Autowired
    private TravellerService travellerService;

    @PostMapping("/get")
    @ResponseBody
    public Traveler getTraveller(@RequestParam String email) {
        LOG.info("Get traveller");
        return travellerService.getTravellerByEmail(email).orElseThrow(NoSuchElementException::new);
    }

    @PostMapping("/create")
    @ResponseBody
    public Traveler createTraveller(@RequestParam String email) {
        LOG.info("Create traveller");
        return travellerService.createTravellerWithEmail(email);
    }

    @DeleteMapping
    public void deleteTraveller() {
        LOG.info("Delete traveller");
    }

}
