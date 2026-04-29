package com.aop.application.aspects;
import com.aop.application.Account;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(1)
@Component
public class LoggingAdvice {

    private static final Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @AfterThrowing(pointcut = "execution(* com.aop.application.repository.AccountRepoImpl.findAllAccounts(..))",throwing = "exception")
    public void adviceAfterThrowingException(Throwable exception){
        System.out.println("LOGGING ERROR OCCURRED!");
    }
}
