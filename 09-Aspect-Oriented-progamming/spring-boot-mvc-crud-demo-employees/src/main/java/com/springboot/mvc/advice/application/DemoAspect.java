package com.springboot.mvc.advice.application;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class DemoAspect {

    Logger logger = Logger.getLogger(getClass().getName());
    @Pointcut("execution(* com.springboot.mvc.advice.application.controller.*.*(..))")
    public void pathController(){}

    @Pointcut("execution(* com.springboot.mvc.advice.application.service.*.*(..))")
    public void pathService(){}

    @Pointcut("execution(* com.springboot.mvc.advice.application.dao.*.*(..))")
    public void pathDao(){}

    @Pointcut("pathContoller() || pathService() || pathDao()")
    public void forAppFlow(){}

//    if any of them gets hit then what to do?
//    Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        logger.info("===> Method called: "+ joinPoint.getSignature().getName());
        logger.info("===> Arguments passed: "+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "forAppFlow()",returning = "result")
    public void afterReturn(JoinPoint joinPoint,Object result){
        logger.info("===> Method called: "+ joinPoint.getSignature().getName());
        logger.info("===> Object Result: "+ result);
    }




}
