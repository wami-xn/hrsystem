package com.wami.project.hrsystem.core.struts2.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;


public class PrivInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //System.out.println("before invocation.invoke...");
        String url = actionInvocation.getProxy().getActionName();
        System.out.println(url);

        if (url.equals("login")){
            return actionInvocation.invoke();
        }else{
            HttpSession session = ServletActionContext.getRequest().getSession();

            Object obj  = session.getAttribute("privileges");
            if (obj instanceof List) {
                List privileges = (List) obj;
                for(Object object: privileges){
                    if(object.equals()){
                        return actionInvocation.invoke();
                    }
                }
            }
            return "lackpriv";
        }
    }
}
