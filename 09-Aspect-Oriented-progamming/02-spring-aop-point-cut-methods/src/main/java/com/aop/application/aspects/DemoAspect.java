package com.aop.application.aspects;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//Contains related advices
@Component
public class DemoAspect {

//    Return type is always void
//    Creating a pointcut
    @Pointcut("execution(* com.aop.application.repository.*.*(..))")
    private void reusePointCut(){}


//    applying the pointcut
    @Before("reusePointCut()")
    public void pointcutApplied(){
        System.out.println("===> LISTENING <===");
    }

}
