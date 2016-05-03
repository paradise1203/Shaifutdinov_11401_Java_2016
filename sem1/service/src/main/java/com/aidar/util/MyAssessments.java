package com.aidar.util;

import com.aidar.model.Assessment;

import java.util.List;

/**
 * Created by paradise on 03.05.16.
 */
public class MyAssessments {

    private int bad;

    private int normal;

    private int good;

    public MyAssessments() {
    }

    public MyAssessments(List<Assessment> assessments) {
        bad = 0;
        normal = 0;
        good = 0;

        assessments.forEach(a -> {
            switch (a.getAssessmentType()) {
                case BAD:
                    bad++;
                    break;
                case NORMAL:
                    normal++;
                    break;
                case GOOD:
                    good++;
            }
        });
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

}
