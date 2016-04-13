package com.aidar.repository;

import com.aidar.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by paradise on 08.04.16.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findOneByEmail(String email);

}
