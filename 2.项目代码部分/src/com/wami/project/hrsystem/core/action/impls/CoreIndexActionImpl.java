package com.wami.project.hrsystem.core.action.impls;

import com.opensymphony.xwork2.ActionContext;
import com.wami.project.hrsystem.core.action.abstractaction.AbstractActionImpl;
import com.wami.project.hrsystem.core.dao.interfaces.LoginDao;
import com.wami.project.hrsystem.core.utils.Md5Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoreIndexActionImpl extends AbstractActionImpl {
    @Autowired
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    private LoginDao loginDao;
    @Override
    public String execute() throws Exception {
        super.execute();
//        context.getValueStack().push(new Md5Handler());
        return "success";
    }
}
