package com.aidar.enums;

/**
 * Created by paradise on 29.04.16.
 */
public enum  AssessmentType {

    BAD,
    NORMAL,
    GOOD;

    public static AssessmentType getAssessmentType(String assessment) {
        for (AssessmentType t : values()) {
            if (t.toString().equalsIgnoreCase(assessment)) {
                return t;
            }
        }
        return null;
    }

}
