package com.aidar.repository;

import com.aidar.enums.RequestStatus;
import com.aidar.model.Request;
import com.aidar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by paradise on 16.04.16.
 */
@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findByNeedy(User needy);

    List<Request> findByNeedyOrVolunteer(User needy, User volunteer);

    // TODO invalid
    List<Request> findAllByStatus(RequestStatus status);

}
