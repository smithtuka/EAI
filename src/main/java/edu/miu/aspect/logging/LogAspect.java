package edu.miu.aspect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // to implement security related use-case after rebasing with Fortune

    @Before("execution(* edu.miu..* .*(..))")
    public void error1LogAdvice(){
        System.out.println( "_____We are all about quality _______" );
    }


    @Before("within(edu.miu.aspect.exception.ControllerAdvisor)")
    public void logAdvice(){
        System.out.println(   "!!---exception__ recorded!!");
    }

//
    @Around("execution(* edu.miu.dao.* .find(..))")
    public void errorLogAdvice(){
//        System.out.println( joinPoint.getArgs().getClass().getName() + " is source of the exception");
    }





}
