package com.aidar.service;

import com.aidar.model.Assessment;

import java.util.List;

/**
 * Created by paradise on 29.04.16.
 */
public interface AssessmentService {

    List<Assessment> getMy();

    List<Assessment> getByUser(Long id);

    void assess(Long id, String assessment);

}
