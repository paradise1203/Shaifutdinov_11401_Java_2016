package com.aidar.o12;

import org.springframework.stereotype.Component;

/**
 * Created by paradise on 24.03.16.
 */
@Component
public class SomeObject {

    public void execute(String statement) {
        System.out.println("Execute " + statement);
    }

}
