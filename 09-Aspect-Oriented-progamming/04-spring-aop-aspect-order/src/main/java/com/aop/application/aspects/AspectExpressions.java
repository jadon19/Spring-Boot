package com.aop.application.aspects;

import org.aspectj.lang.annotation.Pointcut;
//using @Aspect is optional if you only have @PointCut
public class AspectExpressions {
    @Pointcut("execution(* com.aop.application.repository.*.*(..))")
    public void reusePointCut(){}
}
