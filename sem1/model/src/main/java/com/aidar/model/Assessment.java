package com.aidar.model;

import com.aidar.enums.AssessmentType;

import javax.persistence.*;

/**
 * Created by paradise on 29.04.16.
 */
@Entity
@Table(name = "assessment")
@SequenceGenerator(name = "assessment_gen",
        sequenceName = "assessment_seq", allocationSize = 1)
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assessment_gen")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "estimator_id")
    private User estimator;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "estimated_id")
    private User estimated;

    @Column(name = "assessment_type")
    @Enumerated(EnumType.STRING)
    private AssessmentType assessmentType;

    public Assessment() {
    }

    public Assessment(User estimator, User estimated) {
        this.estimator = estimator;
        this.estimated = estimated;
    }

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
}
