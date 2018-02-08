package com.wami.project.hrsystem.core.aspect.log;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class DaoLogAspect extends LogAspect {
    @Pointcut("execution(* com.wami.project.hrsystem.core.dao.impls.actualimpls.*.*(..))")
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
