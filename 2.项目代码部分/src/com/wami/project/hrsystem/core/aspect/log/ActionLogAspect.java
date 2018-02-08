package com.wami.project.hrsystem.core.aspect.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Deprecated
public class ActionLogAspect extends LogAspect {
    @Pointcut("execution(* com.wami.project.hrsystem.core.action.impls.*.*(..))")
    @Override
    public void declareJoinPointExpression() {

    }
    @Before("declareJoinPointExpression()")
    @Override
    public void beforeMethod(JoinPoint joinPoint) {
        getLogger().info(joinPoint.getSignature().getName() + " is executing with args " + Arrays.asList(joinPoint.getArgs()));
    }
    @AfterReturning(value = "declareJoinPointExpression()",returning = "result")
    @Override
    public void afterReturning(JoinPoint joinPoint, Object result) {
        getLogger().info(joinPoint.getSignature().getName() + " execute success with result " + result);
    }
    @AfterThrowing(value = "declareJoinPointExpression()", throwing = "throwable")
    @Override
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        getLogger().info(joinPoint.getSignature().getName() + " execute failed with throwable " + throwable);
    }
}
