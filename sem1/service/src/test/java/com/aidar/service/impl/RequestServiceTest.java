package com.aidar.service.impl;

import com.aidar.config.RequestServiceTestConfig;
import com.aidar.enums.RequestStatus;
import com.aidar.model.Request;
import com.aidar.model.User;
import com.aidar.repository.RequestRepository;
import com.aidar.repository.UserRepository;
import com.aidar.service.GoogleMapsService;
import com.aidar.service.RequestService;
import com.aidar.service.SecurityService;
import com.aidar.util.google_api.LocationBody;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by paradise on 06.05.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RequestServiceTestConfig.class,
        loader = AnnotationConfigContextLoader.class)
public class RequestServiceTest {

    @Autowired
    private RequestService requestService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private GoogleMapsService googleMapsService;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getAllShouldReturnAllRequests() {
        List<Request> requests = new ArrayList<>();
        Request request = new Request();
        request.setId(0);
        requests.add(request);
        when(requestRepository.findAll()).thenReturn(requests);
        assertEquals(requests, requestService.getAll());
    }

    @Test
    public void getMyShouldReturnCurrentPrincipalRequests() {
        User user = new User();
        user.setId(0);
        List<Request> requests = new ArrayList<>();
        Request request = new Request();
        request.setId(0);
        requests.add(request);
        when(securityService.getPersistedPrincipal()).thenReturn(user);
        when(requestRepository.findAllByNeedyOrVolunteer(user, user)).thenReturn(requests);
        List<Request> result = requestService.getMy();
        verify(securityService, times(1)).getPersistedPrincipal();
        assertEquals(requests, result);
    }

    @Test
    @Ignore
    public void getPendingShouldReturnOtherUsersPendingRequests() {
        Request request = new Request();
        request.setId(0);
        List<Request> pending = mock(ArrayList.class);
        when(pending.get(0)).thenReturn(request);
        when(requestRepository.findAllByStatus(RequestStatus.PENDING)).thenReturn(pending);
        User principal = new User();
        when(securityService.getPersistedPrincipal()).thenReturn(principal);
        when(requestRepository.findAllByNeedy(any(User.class))).thenReturn(new ArrayList<>());
//        when(pending.removeAll(requestRepository.findAllByNeedy(principal))).thenReturn(pending);
//        when(pending.removeAll())

    }

    @Test
    public void getClosedAsVolunteerShouldReturnAllClosedRequestsOfParticularVolunteer() {
        User user = new User();
        user.setId(0);
        List<Request> requests = new ArrayList<>();
        Request request = new Request();
        request.setId(0);
        requests.add(request);
        when(userRepository.findOne(user.getId())).thenReturn(user);
        when(requestRepository.findAllByVolunteerAndStatus(user, RequestStatus.CLOSED))
                .thenReturn(requests);
        assertEquals(requests, requestService.getClosedAsVolunteer(user.getId()));
    }

    @Test
    public void getClosedAsNeedyShouldReturnAllClosedRequestsOfParticularNeedy() {

    }

    @Test
    public void getOneShouldReturnOneRequestWithSpecifiedId() {
        Request request = new Request();
        request.setId(0);
        when(requestRepository.findOne(request.getId())).thenReturn(request);
        assertEquals(request, requestService.getOne(request.getId()));
    }

    @Test
    @Ignore
    public void addShouldWorkCorrect() {
        LocationBody locationBody = mock(LocationBody.class);
        when(locationBody.getLatitude()).thenReturn(any(Double.class));
        when(locationBody.getLongitude()).thenReturn(any(Double.class));
        when(googleMapsService.getLocation(any(String.class))).thenReturn(locationBody);

    }

    @Test
    public void closeShouldWorkCorrect() {
        Request request = mock(Request.class);
        when(request.getId()).thenReturn(0L);
        when(requestRepository.findOne(request.getId())).thenReturn(request);
        requestService.close(request.getId());
        verify(requestRepository, times(1)).findOne(request.getId());
        verify(request, times(1)).setStatus(RequestStatus.CLOSED);
    }

}
