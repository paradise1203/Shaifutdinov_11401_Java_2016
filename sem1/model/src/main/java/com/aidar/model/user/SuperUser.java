package com.aidar.model.user;

import javax.persistence.*;

/**
 * Created by paradise on 08.04.16.
 */
@Entity
@Table(name = "super_users")
@SequenceGenerator(name = "super_users_gen",
        sequenceName = "super_users_seq", allocationSize = 1)
public class SuperUser extends AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "super_users_gen")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
