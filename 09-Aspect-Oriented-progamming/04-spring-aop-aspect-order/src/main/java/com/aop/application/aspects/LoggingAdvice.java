package com.aop.application.aspects;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class LoggingAdvice {

    @Before("com.aop.application.aspects.AspectExpressions.reusePointCut()")
    public void loggingAdvice(){
        System.out.println("===> LOGGING INFORMATION <===");
    }
}
