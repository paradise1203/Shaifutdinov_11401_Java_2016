package com.aidar.repository;

import com.aidar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by paradise on 08.04.16.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);

}
