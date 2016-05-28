package com.aidar.web.data.enums;

/**
 * Created by paradise on 16.04.16.
 */
public enum RequestStatus {

    PENDING("pending"),
    ACTIVE("active"),
    CLOSED("closed");

    private String representation;

    RequestStatus(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    @Override
    public String toString() {
        return getRepresentation();
    }

}
