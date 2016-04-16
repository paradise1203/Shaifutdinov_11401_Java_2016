package com.aidar.model;

import com.aidar.enums.ServiceType;
import com.aidar.model.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by paradise on 13.04.16.
 */
@Entity
@Table(name = "request")
@SequenceGenerator(name = "request_gen",
        sequenceName = "request_seq", allocationSize = 1)
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_gen")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "needy_user_id")
    private User needy;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "volunteer_user_id")
    private User volunteer;

    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getNeedy() {
        return needy;
    }

    public void setNeedy(User needy) {
        this.needy = needy;
    }

    public User getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(User volunteer) {
        this.volunteer = volunteer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
