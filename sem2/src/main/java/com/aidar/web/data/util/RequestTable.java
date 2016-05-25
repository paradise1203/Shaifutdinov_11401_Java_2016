package com.aidar.web.data.util;

import java.util.Date;

/**
 * Created by paradise on 25.05.16.
 */
public class RequestTable {

    private String needy;

    private String volunteer;

    private String address;

    private Date createdAt;

    private String serviceType;

    private String status;

    public String getNeedy() {
        return needy;
    }

    public void setNeedy(String needy) {
        this.needy = needy;
    }

    public String getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(String volunteer) {
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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
