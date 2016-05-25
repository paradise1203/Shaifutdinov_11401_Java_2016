package com.aidar.api.util;

import com.aidar.api.rest.ApiResponse;
import com.aidar.service.GoogleMapsService;
import com.aidar.util.google_api.LocationBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by paradise on 25.05.16.
 */
@Component
public class RequestValidator {

    @Autowired
    private GoogleMapsService googleMapsService;

    public boolean validate(String address, ApiResponse apiResponse) {
        LocationBody location = null;
        if (address != null && !address.isEmpty()) {
            location = googleMapsService.getLocation(address);
        }
        if (location == null) {
            apiResponse.addError("Enter valid address");
            apiResponse.setHttpStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            return false;
        }
        return true;
    }

}
