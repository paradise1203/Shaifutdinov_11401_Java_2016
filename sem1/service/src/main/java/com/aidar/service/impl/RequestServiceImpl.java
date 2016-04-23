package com.aidar.service.impl;

import com.aidar.enums.RequestStatus;
import com.aidar.model.Request;
import com.aidar.repository.RequestRepository;
import com.aidar.service.RequestService;
import com.aidar.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by paradise on 21.04.16.
 */
@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private SecurityService securityService;

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public void add(Request request) {
        request.setNeedy(securityService.getPersistedPrincipal());
        request.setCreatedAt(new Date());
        request.setStatus(RequestStatus.PENDING);
        requestRepository.save(request);
    }

}
