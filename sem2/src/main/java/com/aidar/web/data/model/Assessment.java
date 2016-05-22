package com.aidar.web.data.model;

import com.aidar.web.data.enums.AssessmentType;

/**
 * Created by paradise on 29.04.16.
 */
public class Assessment {

    private Long id;

    private User estimator;

    private User estimated;

    private AssessmentType assessmentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getEstimator() {
        return estimator;
    }

    public void setEstimator(User estimator) {
        this.estimator = estimator;
    }

    public User getEstimated() {
        return estimated;
    }

    public void setEstimated(User estimated) {
        this.estimated = estimated;
    }

    public AssessmentType getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(AssessmentType assessmentType) {
        this.assessmentType = assessmentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assessment)) return false;

        Assessment that = (Assessment) o;

        if (!getId().equals(that.getId())) return false;
        if (!getEstimator().equals(that.getEstimator())) return false;
        if (!getEstimated().equals(that.getEstimated())) return false;
        return getAssessmentType() == that.getAssessmentType();

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getEstimator().hashCode();
        result = 31 * result + getEstimated().hashCode();
        result = 31 * result + getAssessmentType().hashCode();
        return result;
    }
}
