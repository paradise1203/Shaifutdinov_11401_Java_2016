package com.aidar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by paradise on 23.04.16.
 */
@Component
@Aspect
public class ServiceAspect {

    private Logger logger = LogManager.getLogger("ServiceLogger");

    // TODO Logger doesn`t work
    @Around("execution(* com.aidar.service.*.*(..))")
    public Object logMethodInvocation(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        logger.debug("Start invoking "
                + jp.getTarget().getClass().getSimpleName()
                + "."
                + jp.getSignature().getName()
        );
        Object result = jp.proceed();
        long end = System.currentTimeMillis();
        logger.debug("Method invocation took " + (end - start) + " seconds.");
        return result;
    }

}
