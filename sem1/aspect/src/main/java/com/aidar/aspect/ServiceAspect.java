package com.aidar.aspect;

import org.apache.log4j.Logger;
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

    private final static Logger logger = Logger.getLogger(ServiceAspect.class);

    @Around("execution(* com.aidar.service.*.*(..))")
    public Object logMethodInvocation(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        logger.info("Start invoking service"
                + jp.getTarget().getClass().getSimpleName()
                + "."
                + jp.getSignature().getName()
        );
        Object result = jp.proceed();
        long end = System.currentTimeMillis();
        logger.info("Method invocation took " + (end - start) + " seconds.");
        logger.debug("debug!!!");
        logger.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return result;
    }

}
