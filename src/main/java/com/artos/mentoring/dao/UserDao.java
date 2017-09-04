package com.artos.mentoring.dao;

import com.artos.mentoring.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Benjámin Árva on 2017. 09. 04..
 */
public interface UserDao extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
