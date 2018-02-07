package com.wami.project.hrsystem.core.dao.impls;

import com.wami.project.hrsystem.core.dao.exceptions.UserAlreadyExistException;
import com.wami.project.hrsystem.core.dao.exceptions.UserNotFoundException;
import com.wami.project.hrsystem.core.dao.impls.abstractimpls.DaoImpl;
import com.wami.project.hrsystem.core.dao.interfaces.LoginDao;
import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "LoginDao")
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
        String hql = "FROM PrivUsersEntity t WHERE t.uname = :USERNAME AND t.upwd = :USERPASSWD";
        return getSession()
                .createQuery(hql, PrivUsersEntity.class)
                .setParameter("USERNAME", usersEntity.getUname())
                .setParameter("USERPASSWD", usersEntity.getUpwd())
                .uniqueResult();
    }

    @Override
    public Boolean check(PrivUsersEntity usersEntity) {
        String hql = "SELECT count(*) FROM PrivUsersEntity t WHERE t.uname = :USERNAME AND t.upwd = :USERPASSWD";
//        System.out.println((Long)getSession().createQuery(hql).setParameter("USERNAME", usersEntity.getUname()).setParameter("USERPASSWD", usersEntity.getUpwd()).uniqueResult());
        return (Long)getSession()
                .createQuery(hql)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                .setParameter("USERNAME", usersEntity.getUname()).uniqueResult();
<<<<<<< HEAD
        System.out.println(passwd);
        System.out.println(usersEntity.getUpwd());
        return passwd != null && Md5Handler.getSaltverifyMD5(usersEntity.getUpwd(), passwd);
=======
                .setParameter("USERNAME", usersEntity.getUname())
                .setParameter("USERPASSWD", usersEntity.getUpwd())
                .uniqueResult() > 0;
>>>>>>> parent of c77bf88... 1.0-001-0
=======
                .setParameter("USERNAME", usersEntity.getUname())
                .setParameter("USERPASSWD", usersEntity.getUpwd())
                .uniqueResult() > 0;
>>>>>>> parent of c77bf88... 1.0-001-0
=======
                .setParameter("USERNAME", usersEntity.getUname())
                .setParameter("USERPASSWD", usersEntity.getUpwd())
                .uniqueResult() > 0;
>>>>>>> parent of c77bf88... 1.0-001-0
=======
        return Md5Handler.getSaltverifyMD5(usersEntity.getUpwd(), passwd);
>>>>>>> parent of 2d692c5... 1.0-001-1
=======
                .setParameter("USERNAME", usersEntity.getUname())
                .setParameter("USERPASSWD", usersEntity.getUpwd())
                .uniqueResult() > 0;
>>>>>>> parent of c77bf88... 1.0-001-0
    }
}
