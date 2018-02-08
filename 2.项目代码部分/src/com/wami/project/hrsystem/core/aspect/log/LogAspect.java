package com.wami.project.hrsystem.core.aspect.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public abstract class LogAspect {
    private final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    protected Logger getLogger(){
        return LOG;
    }
    public abstract void declareJoinPointExpression();
    public abstract void beforeMethod(JoinPoint joinPoint);
    public abstract void afterReturning(JoinPoint joinPoint, Object result);
    public abstract void afterThrowing(JoinPoint joinPoint, Throwable throwable);
}
