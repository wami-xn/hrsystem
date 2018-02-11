package com.wami.project.hrsystem.core.action.impls;

import com.wami.project.hrsystem.core.action.abstractaction.AbstractActionImpl;
import com.wami.project.hrsystem.core.dao.interfaces.LoginDao;
import com.wami.project.hrsystem.core.dao.interfaces.PrivilegeDao;
import com.wami.project.hrsystem.core.enties.functional.ErrorMessageEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivInterfaceEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivModelEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;
import com.wami.project.hrsystem.core.utils.Md5Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.*;

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

    public String loginIdentify() throws Exception {
        super.execute();
        PrivUsersEntity privUsersEntity = new PrivUsersEntity();
        privUsersEntity.setUname(getUser());
        privUsersEntity.setUpwd(getPasswd());
        request.getSession();
        request.getSession().setAttribute("user", privUsersEntity);
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
            request.getSession().setAttribute("PrivNodeTree", getNodeTree(privileges));
            this.setOtherSessionParameter();
            this.setOtherCookies();
            return "success";
        }else {
            ErrorMessageEntity error = new ErrorMessageEntity("用户名或密码错误，请重新登陆！");
            valueStack.push(error);
            return "login";
        }
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


    private Map<PrivModelEntity, List<PrivInterfaceEntity>> getNodeTree(List<Long> privileges){
        List<PrivInterfaceEntity> interfaceEntities = privilegeDao.getAccessAbleInterface(privileges);
        List<PrivModelEntity> modelEntities = privilegeDao.getAccessAbleModel(privileges);
        Map<PrivModelEntity, List<PrivInterfaceEntity>> nodeTreeMap = new HashMap<>();
        for(PrivModelEntity modelEntity: modelEntities){
            List<PrivInterfaceEntity> privInterfaceEntities = new ArrayList<>();
            for(PrivInterfaceEntity interfaceEntity: interfaceEntities){
                if(interfaceEntity.getModelId().equals(modelEntity.getModelId())){
                    privInterfaceEntities.add(interfaceEntity);
                }
            }
            nodeTreeMap.put(modelEntity, privInterfaceEntities);
        }
        return nodeTreeMap;
    }
}
