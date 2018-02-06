package com.wami.project.hrsystem.core.action.abstractaction;


import com.wami.project.hrsystem.core.dao.interfaces.LoginDao;


public abstract class AbstractLoginAction extends AbstractActionImpl {
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    private LoginDao loginDao;
}
