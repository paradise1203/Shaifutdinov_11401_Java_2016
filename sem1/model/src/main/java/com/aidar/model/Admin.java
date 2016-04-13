package com.aidar.model;

import javax.persistence.*;

/**
 * Created by paradise on 08.04.16.
 */
@Entity
@Table(name = "admin")
@SequenceGenerator(name = "admin_gen", sequenceName = "admin_seq", allocationSize = 1)
public class Admin extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_gen")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
