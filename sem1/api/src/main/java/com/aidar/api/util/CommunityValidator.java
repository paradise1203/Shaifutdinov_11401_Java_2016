package com.aidar.api.util;

import com.aidar.api.rest.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by paradise on 28.05.16.
 */
@Component
public class CommunityValidator {

    public boolean validate(String name, String description, ApiResponse apiResponse) {
        if (name == null || name.length() < 1 || name.length() > 20) {
            apiResponse.addError("Name - from 1 to 20 symbols");
        }
        if (description == null || description.isEmpty()) {
            apiResponse.addError("Description - not empty");
        }
        if (apiResponse.getErrors().isEmpty()) {
            apiResponse.setHttpStatus(HttpStatus.OK);
            return true;
        }
        apiResponse.setHttpStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        return false;
    }

}
