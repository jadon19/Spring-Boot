package com.aop.application.aspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(1)
@Component
public class LoggingAdvice {

    @Before("com.aop.application.aspects.AspectExpressions.reusePointCut()")
    public void loggingAdvice(JoinPoint myJoinPoint){
        System.out.println("===> LOGGING INFORMATION <===");
        System.out.println(myJoinPoint.getSignature());
        System.out.println(Arrays.toString(myJoinPoint.getArgs()));
    }
}
