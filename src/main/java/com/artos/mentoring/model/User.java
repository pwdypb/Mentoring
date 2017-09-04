package com.artos.mentoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Benjámin Árva on 2017. 09. 04..
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
