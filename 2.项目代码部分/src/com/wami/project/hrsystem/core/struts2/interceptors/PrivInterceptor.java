package com.wami.project.hrsystem.core.struts2.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.ognl.OgnlValueStack;
import com.opensymphony.xwork2.util.ValueStack;
import com.wami.project.hrsystem.core.dao.interfaces.PrivilegeDao;
import com.wami.project.hrsystem.core.enties.functional.ErrorMessageEntity;
import com.wami.project.hrsystem.core.utils.Md5Handler;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrivInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ValueStack valueStack = actionInvocation.getStack();
        //System.out.println("before invocation.invoke...");
        String url = actionInvocation.getProxy().getActionName();
        System.out.println(url);

        if (url.equals("core_login")){
            return actionInvocation.invoke();
        }else{
            HttpServletRequest request = ServletActionContext.getRequest();
            System.out.println(request.getAttribute("struts.valueStack"));
//            OgnlValueStack ognlValueStack = (OgnlValueStack)request.getAttribute("struts.valueStack");
//            ognlValueStack.push("error");
//            ognlValueStack.set("error","error");
            HttpSession session = ServletActionContext.getRequest().getSession();
            System.out.println(session);
            Cookie[] cookies = ServletActionContext.getRequest().getCookies();
            boolean flag = false;
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("idtf")){
                    if(Md5Handler.getSaltverifyMD5((String) session.getAttribute("Jsession_id"),cookie.getValue())){
                        flag = true;
                    }
                }
            }
            if(!flag){
//                response.set
//                hashMap.put("fieldErrors","请先登陆，再进行其他操作。");
//                valueStack.push(hashMap);
//                return "login";
                ErrorMessageEntity error = new ErrorMessageEntity("请先登陆，再进行其他操作。");
                valueStack.push(error);
            }
            ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/ApplicationContext.xml");
            System.out.println(ctx);
            Map<String, Long> privMap = ctx.getBean(PrivilegeDao.class).getPrivMap();
            System.out.println(privMap);
            Long priv = privMap.get(url);
            Object obj  = session.getAttribute("privileges");
            if (obj instanceof List) {
                List privileges = (List) obj;
                for(Object object: privileges){
                    if(object.toString().equals(priv.toString())){
                        return actionInvocation.invoke();
                    }
                }
            }
            for(Map.Entry entry :actionInvocation.getStack().getContext().entrySet()){
                System.out.println(entry.getKey() +""+entry.getValue());
            }
//            session.setAttribute("fieldErrors","权限不足，请联系主管");
//            request.setAttribute();
            ErrorMessageEntity error = new ErrorMessageEntity("权限不足，请联系主管。");
            valueStack.push(error);
            for(Map.Entry entry :actionInvocation.getStack().getContext().entrySet()){
                System.out.println(entry.getKey() +""+entry.getValue());
            }
            return "lackpriv";
        }
    }
}
