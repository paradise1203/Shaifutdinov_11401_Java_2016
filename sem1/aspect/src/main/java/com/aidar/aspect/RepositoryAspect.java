package com.aidar.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by paradise on 23.04.16.
 */
@Component
@Aspect
public class RepositoryAspect {

    // TODO
    @Around("execution(* com.aidar.repository.*.*(..))")
    public Object logMethodInvocation(ProceedingJoinPoint jp) throws Throwable {
        return jp.proceed();
    }

}
