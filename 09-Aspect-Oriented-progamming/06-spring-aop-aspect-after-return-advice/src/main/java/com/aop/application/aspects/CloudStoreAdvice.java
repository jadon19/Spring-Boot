package com.aop.application.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class CloudStoreAdvice {

    @Before("com.aop.application.aspects.AspectExpressions.reusePointCut()")
    public void storeCloudAdvice(){
        System.out.println("===> STORING INFORMATION IN CLOUD <===");
    }

}
