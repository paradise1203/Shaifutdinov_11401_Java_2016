package com.aidar.service;

import com.aidar.model.SomeEntity;
import com.aidar.repository.SomeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by paradise on 08.04.16.
 */
@Service
public class SomeService {

    @Autowired
    private SomeEntityRepository someEntityRepository;

    public List<SomeEntity> getSomeEntities() {
        return someEntityRepository.findAll();
    }

}
