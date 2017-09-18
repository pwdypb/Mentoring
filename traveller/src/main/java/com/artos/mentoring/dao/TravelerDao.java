package com.artos.mentoring.dao;

import com.artos.mentoring.model.Traveler;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Benjámin Árva on 2017. 09. 04..
 */
public interface TravelerDao extends CrudRepository<Traveler, Long> {

    Traveler findByEmail(String email);
}
