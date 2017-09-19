package com.artos.mentoring.service;

import com.artos.mentoring.dao.TravelerDao;
import com.artos.mentoring.model.Traveler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Gyula_Sajtos on 2017-09-19.
 */
@Service
public class DefaultTravellerService implements TravellerService {

    @Autowired
    private TravelerDao travelerDao;

    @Override
    public Optional<Traveler> getTravellerByEmail(String email) {
        return travelerDao.findByEmail(email);
    }

    @Override
    public Traveler createTravellerWithEmail(String email) {
        return null;
    }

}
