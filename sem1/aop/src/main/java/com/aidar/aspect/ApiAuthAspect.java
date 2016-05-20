package com.aidar.aspect;

import com.aidar.api.security.AuthService;
import com.aidar.enums.Role;
import com.aidar.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by paradise on 17.05.16.
 */
@Component
@Aspect
public class ApiAuthAspect {

    @Autowired
    private AuthService authService;

    @Around("@annotation(com.aidar.api.security.annotation.RequireAnonymous)")
    public Object requireAnonymous(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        if (authService.getAuthentication(request) == null) {
            return jp.proceed();
        }
        response.sendRedirect("/api/forbidden");
        return null;
    }

    @Around("@annotation(com.aidar.api.security.annotation.RequireAuthentication)")
    public Object requireAuthentication(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        if (authService.getAuthentication(request) != null) {
            return jp.proceed();
        }
        response.sendRedirect("/api/forbidden");
        return null;
    }

    @Around("@annotation(com.aidar.api.security.annotation.RequireUserAuth)")
    public Object requireUserAuth(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        User user = authService.getAuthentication(request);
        if (user != null && user.getRole() == Role.ROLE_USER) {
            return jp.proceed();
        }
        response.sendRedirect("/api/forbidden");
        return null;
    }

    @Around("@annotation(com.aidar.api.security.annotation.RequireSuperUserAuth)")
    public Object requireSuperUserAuth(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        User user = authService.getAuthentication(request);
        if (user != null && user.getRole() == Role.ROLE_ADMIN) {
            return jp.proceed();
        }
        response.sendRedirect("/api/forbidden");
        return null;
    }

}
