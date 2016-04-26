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

    // TODO Logger doesn`t work
    @Around("execution(* com.aidar.service.*.*(..))")
    public Object logMethodInvocation(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        if (logger.isDebugEnabled()) {
            logger.debug("Start invoking "
                    + jp.getTarget().getClass().getSimpleName()
                    + "."
                    + jp.getSignature().getName()
            );
        }
        Object result = jp.proceed();
        long end = System.currentTimeMillis();
        if (logger.isInfoEnabled()) {
            logger.info("Method invocation took " + (end - start) + " seconds.");
        }
        return result;
    }

}
