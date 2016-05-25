package com.aidar.enums;

/**
 * Created by paradise on 13.04.16.
 */
public enum ServiceType {

    MARKET("Buy smth in the market"),
    STREET("Some help on the street"),
    HOME("Some help in the home");

    private String representation;

    ServiceType(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public static ServiceType getByRepresentation(String representation) {
        for (ServiceType serviceType : values()) {
            if (serviceType.getRepresentation().equals(representation)) {
                return serviceType;
            }
        }
        return null;
    }

}
