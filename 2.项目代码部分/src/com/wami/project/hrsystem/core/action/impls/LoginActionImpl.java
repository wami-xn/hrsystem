package com.wami.project.hrsystem.core.action.impls;

import com.wami.project.hrsystem.core.action.abstractaction.AbstractActionImpl;
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
public class LoginActionImpl extends AbstractActionImpl {
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

    public final String loginIdentify() throws Exception {
        super.execute();
        PrivUsersEntity privUsersEntity = new PrivUsersEntity();
        privUsersEntity.setUname(getUser());
        privUsersEntity.setUpwd(getPasswd());
        request.getSession();
        request.getSession().setAttribute("user", privUsersEntity.getUname());
        System.out.println(privUsersEntity.getUname());
        System.out.println(privUsersEntity.getUpwd());
        if(getLoginDao().check(privUsersEntity)){
            Random random = new Random();
            String gession_id = new Date().toString().replace(" ","") + privUsersEntity.getUname() + random.nextInt(99999999);
            Cookie cookie;
            request.getSession().setAttribute("Jsession_id",gession_id);
            String identifier = Md5Handler.getSaltMD5(gession_id);
            cookie = new Cookie("idtf", identifier);
            response.addCookie(cookie);
            List<Long> privileges =  this.getPrivilegeDao().getAllPrivilege(privUsersEntity);
            request.getSession().setAttribute("privileges", privileges);
            setOtherSessionParameter();
            this.setSessionParmeters(privUsersEntity);
            this.setOtherCookies();
            return "success";
        }else {
            return "login";
        }
    }
    private void setSessionParmeters(PrivUsersEntity privUsersEntity){

    }
    @SuppressWarnings("WeakerAccess")
    protected void setOtherCookies(){

    }
    @SuppressWarnings("WeakerAccess")
    protected void setOtherSessionParameter(){

    }
    private String user;
    private String passwd;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
