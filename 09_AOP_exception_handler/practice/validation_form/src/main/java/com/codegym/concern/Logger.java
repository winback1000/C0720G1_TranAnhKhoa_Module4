package com.codegym.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect
public class Logger {

    @AfterThrowing(pointcut = "execution(public * com.codegym.service.UserServiceImpl.findAll(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e){
//        String className = joinPoint.getSignature().getDeclaringTypeName();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(className +"--"+ methodName +"--"+ args );
    }
}
