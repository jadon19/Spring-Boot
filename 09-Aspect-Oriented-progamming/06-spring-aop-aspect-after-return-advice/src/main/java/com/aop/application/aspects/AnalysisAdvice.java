package com.aop.application.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class AnalysisAdvice {
    @Before("com.aop.application.aspects.AspectExpressions.reusePointCut()")
    public void analyticsAdvice(){
        System.out.println("===> ANALYSING DATA <===");
    }
}
