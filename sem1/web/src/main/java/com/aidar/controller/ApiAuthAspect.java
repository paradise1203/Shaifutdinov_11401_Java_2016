package com.aidar.controller;

import com.aidar.enums.Role;
import com.aidar.model.User;
import com.aidar.security.AuthService;
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

    @Around("execution(* com.aidar.controller.ApiAuthController.signIn(..))")
    public Object requireAnonymous(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        if (authService.getAuthentication(request) == null) {
            return jp.proceed();
        }
        response.sendRedirect("redirect:/api/home?token=" + authService.addToken(request));
        return null;
    }

    @Around("@annotation(com.aidar.security.annotation.RequireAuthentication)")
    public Object requireAuthentication(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        if (authService.getAuthentication(request) != null) {
            return jp.proceed();
        }
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }

    @Around("@annotation(com.aidar.security.annotation.RequireUserAuth)")
    public Object requireUserAuth(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        User user = authService.getAuthentication(request);
        if (user != null) {
            return user.getRole() == Role.ROLE_USER;
        }
        response.sendRedirect("/api/sign_in");
        return null;
    }

    @Around("@annotation(com.aidar.security.annotation.RequireSuperUserAuth)")
    public Object requireSuperUserAuth(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        User user = authService.getAuthentication(request);
        if (user != null) {
            return user.getRole() == Role.ROLE_ADMIN;
        }
        response.sendRedirect("/api/sign_in");
        return null;
    }

}
