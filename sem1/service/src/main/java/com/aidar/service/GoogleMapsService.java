package com.aidar.service;

import com.aidar.util.LocationBody;

/**
 * Created by paradise on 01.05.16.
 */
public interface GoogleMapsService {

    LocationBody getLocation(String address);

}
