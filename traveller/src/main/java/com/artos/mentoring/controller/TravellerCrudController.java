package com.artos.mentoring.controller;

import com.artos.mentoring.model.Traveler;
import com.artos.mentoring.service.TravellerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;


/**
 * Created by Gyula_Sajtos on 2017-09-19.
 */
@RestController
public class TravellerCrudController {

    private static final Logger LOG = Logger.getLogger(TravellerCrudController.class);

    @Autowired
    private TravellerService travellerService;

    @RequestMapping
    public Iterable<Traveler> getAllTravellers() {
        LOG.info("Retrieving all travellers");
        return travellerService.getAllTravellers();
    }

    @PostMapping("/get")
    public Traveler getTraveller(@RequestParam String email) {
        LOG.info(String.format("Get traveller by email (%s)", email));
        return travellerService.getTravellerByEmail(email).orElseThrow(NoSuchElementException::new);
    }

    @PostMapping("/create")
    public Traveler createTraveller(@RequestParam String email) {
        LOG.info(String.format("Create traveller with email (%s)", email));
        return travellerService.createTravellerWithEmail(email);
    }

    @PostMapping("/delete")
    public Long deleteTraveller(@RequestParam String email) {
        LOG.info(String.format("Delete traveller by email (%s)", email));
        Long noOfDeletedTravellers = travellerService.deleteTravellerByEmail(email);
        LOG.info(String.format("Deleted %d traveller(s)", noOfDeletedTravellers));
        return noOfDeletedTravellers;
    }

}
