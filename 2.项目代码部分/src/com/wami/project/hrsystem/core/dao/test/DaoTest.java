package com.wami.project.hrsystem.core.dao.test;

import com.wami.project.hrsystem.core.utils.StringHandler;
import com.wami.project.hrsystem.core.dao.interfaces.AbstractUpdateDao;
import com.wami.project.hrsystem.core.dao.interfaces.LoginDao;
import com.wami.project.hrsystem.core.dao.interfaces.PrivilegeDao;
import com.wami.project.hrsystem.core.enties.privs.PrivPrivLEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class DaoTest {
    private DataSource dataSource;
    private LoginDao loginDao;
    private PrivilegeDao privilegeDao;
    ApplicationContext context;
    {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        dataSource = context.getBean(DataSource.class);
        loginDao = context.getBean(LoginDao.class);
        privilegeDao = context.getBean(PrivilegeDao.class);
    }
    @Test
    public void testConnect() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
    @Test
    public void testLogin(){
        PrivUsersEntity privUsersEntity = new PrivUsersEntity();
        privUsersEntity.setUname("SYSTEM");
        privUsersEntity.setUpwd("SYSTEM");
        System.out.println(loginDao.check(privUsersEntity));
        loginDao.insert(privUsersEntity);
        privUsersEntity.setUname("Manager");
        loginDao.insert(privUsersEntity);
    }
    @Test
    public void testPrivilege(){
        PrivUsersEntity privUsersEntity = new PrivUsersEntity();
        privUsersEntity.setUname("SYSTEM");
        privUsersEntity.setUpwd("SYSTEM");
        List<Long> list = privilegeDao.getAllPrivilege(privUsersEntity);
        System.out.println(list);
        System.out.println(privilegeDao.getAccessAbleInterface(list));
        System.out.println(privilegeDao.getAccessAbleModel(list));
    }
    @Test
    public void testUtils(){
        PrivUsersEntity privUsersEntity = new PrivUsersEntity();
        privUsersEntity.setUname("SYSTEM");
        privUsersEntity.setUpwd("SYSTEM");
        List<Long> list = privilegeDao.getAllPrivilege(privUsersEntity);
        System.out.println(StringHandler.Handle(list));
    }
    @Test
    public void testQuery(){
        AbstractUpdateDao<PrivPrivLEntity> updateDao = (AbstractUpdateDao<PrivPrivLEntity>) context.getBean("testImpl");
        PrivPrivLEntity privPrivLEntity = new PrivPrivLEntity();
        privPrivLEntity.setFlowId((long) 4000);
        privPrivLEntity.setPrivilegeId((long) 3001);
        privPrivLEntity.setUserId((long) 1001);
        updateDao.insertOrUpdate(privPrivLEntity);
        System.out.println(updateDao);
    }
}
