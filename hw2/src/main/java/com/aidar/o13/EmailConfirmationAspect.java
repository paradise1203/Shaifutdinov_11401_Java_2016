package com.aidar.o13;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by paradise on 24.03.16.
 */
@Component
@Aspect
public class EmailConfirmationAspect {

    private final Pattern validEmailPattern;

    public EmailConfirmationAspect() {
        validEmailPattern = Pattern.compile("^[\\w\\.\\+\\-_]+@[\\w\\-]+\\.[\\w\\-\\.]{2,}$");
    }

    private void errorMsg(String msg) {
        System.out.println(msg);
    }

    @Around("execution(* *..*.setEmail(String))")
    public Object validateEmail(ProceedingJoinPoint jp) throws Throwable {
        String input = (String) jp.getArgs()[0];
        if (input == null) {
            errorMsg("Provide your email, please");
            return null;
        }
        Matcher m = validEmailPattern.matcher(input);
        if (!m.matches()) {
            errorMsg("Invalid email!");
            return null;
        }
        return jp.proceed();
    }

}
