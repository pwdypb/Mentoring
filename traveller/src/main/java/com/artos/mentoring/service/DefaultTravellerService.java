package com.artos.mentoring.service;

import com.artos.mentoring.dao.TravelerDao;
import com.artos.mentoring.model.Traveler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public Traveler createTravellerWithEmail(String email) {
        Traveler traveller = new Traveler();
        traveller.setEmail(email);
        return travelerDao.save(traveller);
    }

    @Override
    @Transactional
    public Long deleteTravellerByEmail(String email) {
        return travelerDao.deleteByEmail(email);
    }

    @Override
    public Iterable<Traveler> getAllTravellers() {
        return travelerDao.findAll();
    }

}
