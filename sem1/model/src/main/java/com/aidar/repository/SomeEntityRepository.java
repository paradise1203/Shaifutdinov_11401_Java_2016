package com.aidar.repository;

import com.aidar.model.SomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by paradise on 08.04.16.
 */
@Repository
public interface SomeEntityRepository extends JpaRepository<SomeEntity, Long> {
}
