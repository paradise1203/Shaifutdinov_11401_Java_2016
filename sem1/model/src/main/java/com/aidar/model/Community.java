package com.aidar.model;

import com.aidar.model.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by paradise on 13.04.16.
 */
@Entity
@Table(name = "community")
@SequenceGenerator(name = "community_gen",
        sequenceName = "community_seq", allocationSize = 1)
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "community_gen")
    private long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "founder_id")
    private User founder;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getFounder() {
        return founder;
    }

    public void setFounder(User founder) {
        this.founder = founder;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
