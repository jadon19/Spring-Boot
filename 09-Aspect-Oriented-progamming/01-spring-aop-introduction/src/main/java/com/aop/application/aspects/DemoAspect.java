package com.aop.application.aspects;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
//Contains related advices
@Component
public class DemoAspect {
    @Before("execution(public void addAccount())")
    public void executeBeforeAddAccount(){
        System.out.println("===>> @Before Demo: This should run before adding account or member to database <<===");
    }

    @Before("execution(public void com.aop.application.repository.MembershipRepoImpl.addAccount())")
    public void executeOnlyBeforeAddMember(){
        System.out.println("===>> @Before Demo: This should run before adding ONLY member to database <<===");
    }
//    Point cut expressions with wildcard "*"
//    Mandatory fields: return type and signature (optional: modifiers, exceptions etc)
//    Arguments: ()->none, ()*->exactly one of any type, (..)->
    

}
