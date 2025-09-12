package com.example.springbootelplus2025.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class ControllerLogAspect {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 定义切点：拦截所有 controller 包下的方法
     */
    @Pointcut("execution(* com.example.springbootelplus2025.controller..*(..))")
    public void controllerMethods() {}

    /**
     * 请求前打印入参
     */
    @Before("controllerMethods()")
    public void logRequest(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Object[] args = joinPoint.getArgs();
        String params;
        try {
            params = objectMapper.writeValueAsString(args);
        } catch (Exception e) {
            params = "参数序列化失败";
        }

        log.info("【请求开始】URL={}, Method={}, ClassMethod={}, 入参={}",
                request.getRequestURI(),
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                params);
    }

    /**
     * 响应后打印出参
     */
    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logResponse(Object result) {
        String jsonResult;
        try {
            jsonResult = objectMapper.writeValueAsString(result);
        } catch (Exception e) {
            jsonResult = "出参序列化失败";
        }

        log.info("【请求结束】出参={}", jsonResult);
    }
}
