package com.aidar.repository;

import com.aidar.model.user.SuperUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by paradise on 08.04.16.
 */
@Repository
public interface SuperUserRepository extends JpaRepository<SuperUser, Long> {

    SuperUser findOneByEmail(String email);

}
