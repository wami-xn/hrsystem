package com.wami.project.hrsystem.core.action.abstractaction;

import com.wami.project.hrsystem.core.action.interfaces.AbstractNormalAction;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractNormalActionImpl<T> extends AbstractActionImpl<T> implements AbstractNormalAction<T> {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext context;

    protected HttpServletRequest getRequest() {
        return request;
    }

    protected HttpServletResponse getResponse() {
        return response;
    }

    protected ServletContext getContext() {
        return context;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }
}
