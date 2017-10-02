package com.artos.mentoring.service;

import com.artos.mentoring.model.Traveler;

import java.util.Optional;

/**
 * Created by Gyula_Sajtos on 2017-09-19.
 */
public interface TravellerService {

    Optional<Traveler> getTravellerByEmail(String email);

    Traveler createTravellerWithEmail(String email);

    Long deleteTravellerByEmail(String email);

    Iterable<Traveler> getAllTravellers();

}
