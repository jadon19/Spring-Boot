package com.aop.application.aspects;
import com.aop.application.Account;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(1)
@Component
public class LoggingAdvice {

    @Before("com.aop.application.aspects.AspectExpressions.reusePointCut()")
    public void beforeLoggingAccountAdvice(){
        System.out.println("===> LOGGING INFORMATION <===");
    }

    @AfterReturning(pointcut = "execution(* com.aop.application.repository.*.*(..))",returning = "result")
    public void afterLoggingAccountAdvice(List<Account> result){
        System.out.println("==> FROM LOGGING === RETURNED RESULT <==");
//        This really changes the accountList globally
        result.get(0).setName("jingalala");
        System.out.println(result);
    }
}
