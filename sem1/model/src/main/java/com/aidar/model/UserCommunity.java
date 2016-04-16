package com.aidar.model;

import com.aidar.model.user.User;

import javax.persistence.*;

/**
 * Created by paradise on 16.04.16.
 */
@Entity
@Table(name = "user_community")
@SequenceGenerator(name = "user_community_gen",
        sequenceName = "user_community_seq", allocationSize = 1)
public class UserCommunity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_community_gen")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "community_id")
    private Community community;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}
