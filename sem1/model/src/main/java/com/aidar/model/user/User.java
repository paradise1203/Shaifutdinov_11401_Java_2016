package com.aidar.model.user;

import com.aidar.enums.Status;

import javax.persistence.*;

/**
 * Created by paradise on 08.04.16.
 */
@Entity
@Table(name = "users")
@SequenceGenerator(name = "users_gen", sequenceName = "users_seq", allocationSize = 1)
public class User extends AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_gen")
    private long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
