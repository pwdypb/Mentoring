package com.artos.mentoring.dao;

import com.artos.mentoring.model.Traveler;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Benjámin Árva on 2017. 09. 04..
 */
public interface TravelerDao extends CrudRepository<Traveler, Long> {

    Optional<Traveler> findByEmail(String email);

    Long deleteByEmail(String email);

}
