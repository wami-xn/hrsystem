package com.wami.project.hrsystem.core.action.impls;

import com.wami.project.hrsystem.core.action.abstractaction.AbstractNormalActionImpl;
import com.wami.project.hrsystem.core.action.interfaces.AbstractAction;
import com.wami.project.hrsystem.core.action.interfaces.LoginAction;
import com.wami.project.hrsystem.core.dao.interfaces.LoginDao;
import com.wami.project.hrsystem.core.dao.interfaces.PrivilegeDao;
import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;
import com.wami.project.hrsystem.core.utils.Md5Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Service
public class LoginActionImpl extends AbstractNormalActionImpl<PrivUsersEntity> implements LoginAction,AbstractAction<PrivUsersEntity> {
    @Autowired
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    private LoginDao loginDao;
    @Autowired
    public void setPrivilegeDao(PrivilegeDao privilegeDao) {
        this.privilegeDao = privilegeDao;
    }
    @SuppressWarnings("WeakerAccess")
    protected LoginDao getLoginDao() {
        return loginDao;
    }
    @SuppressWarnings("WeakerAccess")
    protected PrivilegeDao getPrivilegeDao() {
        return privilegeDao;
    }

    private PrivilegeDao privilegeDao;

    @Override
    public final String loginIdentify() {
        PrivUsersEntity privUsersEntity = new PrivUsersEntity();
        privUsersEntity.setUname(getRequest().getParameter("uname"));
        privUsersEntity.setUpwd(getRequest().getParameter("passwd"));
        getRequest().getSession().setAttribute("user", privUsersEntity.getUname());
        if(getLoginDao().check(privUsersEntity)){
            Random random = new Random();
            String gession_id = new Date().toString() + privUsersEntity.getUname() + random.nextInt(99999999);
            Cookie cookie = new Cookie("Jsession_id",gession_id);
            getResponse().addCookie(cookie);
            String identifier = Md5Handler.getSaltMD5(gession_id);
            cookie = new Cookie("idtf", identifier);
            getResponse().addCookie(cookie);
            this.setSessionParmeters(privUsersEntity);
            this.setOtherCookies();
            return "success";
        }else {
            return "login";
        }
    }
    private void setSessionParmeters(PrivUsersEntity privUsersEntity){
        List<Long> privileges =  this.getPrivilegeDao().getAllPrivilege(privUsersEntity);
        getRequest().getSession().setAttribute("privileges", privileges);
        setOtherSessionParameter();
    }
    @SuppressWarnings("WeakerAccess")
    protected void setOtherCookies(){

    }
    @SuppressWarnings("WeakerAccess")
    protected void setOtherSessionParameter(){

    }
}
