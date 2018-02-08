package com.wami.project.hrsystem.core.action.abstractaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractActionImpl extends ActionSupport {
    protected ActionContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ValueStack valueStack;
    public String execute() throws Exception{
        context = ActionContext.getContext();
        request =  (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);
        response = (HttpServletResponse)context.get(ServletActionContext.HTTP_RESPONSE);
        valueStack = ActionContext.getContext().getValueStack();
        return "success";
    }
}
