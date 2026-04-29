package com.aop.application.aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class LoggingAdvice {
//Runs with or without exception (always)
    @After("execution(* com.aop.application.repository.AccountRepoImpl.*(..))")
    public void afterLoggingAccountAdvice(){
        System.out.println("===> LOGGING INFORMATION SAVED AFTER EXECUTION <===");
    }

    @Around("execution(* com.aop.application.repository.AccountRepoImpl.*(..))")
    public void aroundLoggingAccountAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        System.out.println("===> LOGGING INFORMATION BEFORE EXECUTION <===");
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("===> LOGGING INFORMATION AFTER EXECUTION <===");
        long timeDifference = end-begin;
        System.out.println("DURATION : "+ timeDifference);


    }


}
