package com.wami.project.hrsystem.core.dao.test;

import com.wami.project.hrsystem.core.dao.interfaces.LoginDao;
import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DaoTest {
    private DataSource dataSource;
    private LoginDao loginDao;
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        dataSource = context.getBean(DataSource.class);
        loginDao = context.getBean(LoginDao.class);
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
}
