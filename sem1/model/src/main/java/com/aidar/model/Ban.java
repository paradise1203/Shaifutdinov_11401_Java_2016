package com.aidar.model;

import com.aidar.model.user.SuperUser;
import com.aidar.model.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by paradise on 13.04.16.
 */
@Entity
@Table(name = "ban")
@SequenceGenerator(name = "ban_gen",
        sequenceName = "ban_seq", allocationSize = 1)
public class Ban {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ban_gen")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "super_user_id")
    private SuperUser superUser;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SuperUser getSuperUser() {
        return superUser;
    }

    public void setSuperUser(SuperUser superUser) {
        this.superUser = superUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
