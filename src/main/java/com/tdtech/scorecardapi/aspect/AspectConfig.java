package com.tdtech.scorecardapi.aspect;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Aspect
public class AspectConfig {

    @Around(value="execution(* com.tdtech.scorecardapi.controller.*.*(..))")
    public Object logControllerInteractionsAndErrors(ProceedingJoinPoint jp) {

        Object returningObject = null;
        String controllerMethod = jp.getSignature().getName();

        log.info(String.format("Controller Request: %s(%s)", controllerMethod, this.getParamsAsString(jp)));

        try {
            returningObject = jp.proceed();
        } catch(Throwable e) {
            log.error(String.format("Caught Exception in controller method [%s]: %s", controllerMethod, e.getMessage()));
        } finally {
            log.info(String.format("Controller Response: %s() -> %s", controllerMethod, returningObject));
        }
        return returningObject;
    }

    private String getParamsAsString(JoinPoint jp) {
        String[] keys = ((MethodSignature) jp.getSignature()).getParameterNames();
        Object[] values = jp.getArgs();

        Map<String, Object> params = new HashMap<>();
        IntStream.range(0, keys.length).boxed().forEach(i -> params.put(keys[i], values[i]));

        return (params.size() > 0)?params.toString():"";
    }
}