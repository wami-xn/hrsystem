package com.wami.project.hrsystem.core.struts2.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogInterceptor extends AbstractInterceptor {
    private Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String url = actionInvocation.getProxy().getActionName();
        LOG.debug("Before Getting into page " + url  + ".");
        String value =  actionInvocation.invoke();
        LOG.debug("Returning '" +value  + "' by action with url " + url + ".");
        return value;
    }
}
