package com.aidar.web.data.util;

import com.aidar.web.data.model.Request;
import com.aidar.web.data.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paradise on 25.05.16.
 */
public class Transformer {

    public static List<RequestTable> transformRequests(List<Request> requests) {
        List<RequestTable> requestTable = new ArrayList<>();
        requests.forEach(r -> {
            RequestTable request = new RequestTable();
            User user = r.getNeedy();
            request.setNeedy(user.getName() + " " + user.getSurname());
            user = r.getVolunteer();
            request.setVolunteer(user != null ? user.getName() + " " + user.getSurname() : "No yet");
            request.setAddress(r.getAddress());
            request.setCreatedAt(r.getCreatedAt());
            request.setServiceType(r.getServiceType().getRepresentation());
            request.setStatus(r.getStatus().getRepresentation());
            requestTable.add(request);
        });
        return requestTable;
    }

}
