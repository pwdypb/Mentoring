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

    @GetMapping
    @ResponseBody
    public Iterable<Traveler> getAllTravellers() {
        LOG.info("Retrieving all travellers");
        return travellerService.getAllTravellers();
    }

    @PostMapping("/get")
    @ResponseBody
    public Traveler getTraveller(@RequestParam String email) {
        LOG.info(String.format("Get traveller by email (%s)", email));
        return travellerService.getTravellerByEmail(email).orElseThrow(NoSuchElementException::new);
    }

    @PostMapping("/create")
    @ResponseBody
    public Traveler createTraveller(@RequestParam String email) {
        LOG.info(String.format("Create traveller with email (%s)", email));
        return travellerService.createTravellerWithEmail(email);
    }

    @PostMapping("/delete")
    @ResponseBody
    public Long deleteTraveller(@RequestParam String email) {
        LOG.info(String.format("Delete traveller by email (%s)", email));
        Long noOfdeletedTravellers = travellerService.deleteTravellerByEmail(email);
        LOG.info("Deleted " + noOfdeletedTravellers);
        return noOfdeletedTravellers;
    }

}
