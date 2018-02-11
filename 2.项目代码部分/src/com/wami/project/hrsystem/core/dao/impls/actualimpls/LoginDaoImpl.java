package com.wami.project.hrsystem.core.dao.impls.actualimpls;

import com.wami.project.hrsystem.core.dao.exceptions.UserAlreadyExistException;
import com.wami.project.hrsystem.core.dao.exceptions.UserNotFoundException;
import com.wami.project.hrsystem.core.dao.impls.abstractimpls.DaoImpl;
import com.wami.project.hrsystem.core.dao.interfaces.LoginDao;
import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;
import com.wami.project.hrsystem.core.utils.Md5Handler;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "LoginDao")
@Transactional
public class LoginDaoImpl extends DaoImpl<PrivUsersEntity> implements LoginDao {
    @Autowired
    public LoginDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    @Override
    public void insert(PrivUsersEntity usersEntity) {
        if(check(usersEntity)){
            throw new UserAlreadyExistException("用户" + usersEntity + "的信息已经存在");
        }else {
            getSession().save(usersEntity);
        }
    }

    @Override
    public void update(PrivUsersEntity usersEntity, String passwd) {
        if(!check(usersEntity)){
            throw new UserNotFoundException("用户" + usersEntity + "的信息不存在");
        }else {
            PrivUsersEntity privUsersEntity = getPrivUsersEntity(usersEntity);
            privUsersEntity.setUpwd(passwd);
            getSession().save(privUsersEntity);
        }
    }

    @Override
    public void delete(PrivUsersEntity usersEntity) {
        if(!check(usersEntity)){
            throw new UserNotFoundException("用户" + usersEntity + "的信息不存在");
        }else {
            PrivUsersEntity privUsersEntity = getPrivUsersEntity(usersEntity);
            getSession().delete(privUsersEntity);
        }
    }

    private PrivUsersEntity getPrivUsersEntity(PrivUsersEntity usersEntity) {
        String hql = "FROM PrivUsersEntity t WHERE t.uname = :USERNAME";
        return getSession()
                .createQuery(hql, PrivUsersEntity.class)
                .setParameter("USERNAME", usersEntity.getUname())
                .uniqueResult();
    }

    @Override
    public Boolean check(PrivUsersEntity usersEntity) {
        String hql = "SELECT t.upwd FROM PrivUsersEntity t WHERE t.uname = :USERNAME";
//        System.out.println((Long)getSession().createQuery(hql).setParameter("USERNAME", usersEntity.getUname()).setParameter("USERPASSWD", usersEntity.getUpwd()).uniqueResult());
        String passwd = (String) getSession()
                .createQuery(hql)
                .setParameter("USERNAME", usersEntity.getUname()).uniqueResult();
        System.out.println(passwd);
        System.out.println(usersEntity.getUpwd());
        return passwd != null && Md5Handler.getSaltverifyMD5(usersEntity.getUpwd(), passwd);
    }
}
