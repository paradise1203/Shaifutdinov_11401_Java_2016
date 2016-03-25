package com.aidar.o12;

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
public class PreventSqlInjectionAspect {

    private boolean containsRegex(String statement, String regex) {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(statement);
        return m.find();
    }

    @Around("execution(* *..*.execute(String))")
    public Object checkForSqlInjection(ProceedingJoinPoint jp) throws Throwable {
        String statement = (String) jp.getArgs()[0];
        if (statement == null) {
            return jp.proceed();
        }
//        Если предположить, что в метод передается параметр запроса, к которому кто-то мог дописать sql-injection.

//        users/id={id} or id=../id like '...';
        if (containsRegex(statement, "\\s+(and|or)\\s+.*;")) {
            return null;
        }
//        users/id={id} union select ...;
        if (containsRegex(statement, "\\s+(union|except)\\s+select\\s+.*\\s+from\\s+.*;")) {
            return null;
        }
//        users/id={id}; и здесь любой другой sql запрос
        if (containsRegex(statement, "\\s*;\\s*(select|insert|update|delete|alter|create|drop)\\s+.*;")) {
            return null;
        }
        return jp.proceed();
    }

}
