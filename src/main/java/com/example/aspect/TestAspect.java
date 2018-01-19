package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * FileName: TestAspect
 *
 * @author gcg
 * @create 2017/12/11 10:38
 * Description: aop test demo
 * History:
 **/
@Aspect
@Component
public class TestAspect {

    private Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Pointcut(value = "execution(* com.example.controller..*.*(..))")
    public void webLog() {}

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(new Date().getTime());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : {}" ,request.getRequestURL().toString());
        logger.info("HTTP_METHOD : {}" ,request.getMethod());
        logger.info("IP : {}" ,request.getRemoteAddr());
        logger.info("CLASS_METHOD : {}.{}" ,joinPoint.getSignature().getDeclaringTypeName() ,joinPoint.getSignature().getName());
        logger.info("ARGS : {}" ,Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : {}" ,ret);
        logger.info("SPEND TIME : {}", System.currentTimeMillis() - startTime.get());
    }

}
