package com.wami.project.hrsystem.core.dao.impls;

import com.wami.project.hrsystem.core.utils.StringHandler;
import com.wami.project.hrsystem.core.dao.impls.abstractimpls.DaoImpl;
import com.wami.project.hrsystem.core.dao.interfaces.PrivilegeDao;
import com.wami.project.hrsystem.core.enties.privs.PrivGroupDEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivInterfaceEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivModelEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository(value = "PrivilegeDao")
public class PrivilegeDaoImpl extends DaoImpl<PrivGroupDEntity> implements PrivilegeDao{
    @Autowired
    public PrivilegeDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Long> getAllPrivilege(PrivUsersEntity privUsersEntity) {
        String hql = "SELECT gl.privilegeId FROM " +
                "PrivUsersEntity u, " +
                "PrivGroupDEntity g, " +
                "PrivGroupPrivEntity gl " +
                "WHERE u.uname = :USERNAME " +
                "AND u.userId = g.userId " +
                "AND g.groupId = gl.groupId";
        Iterator iterator = getSession().createQuery(hql).setParameter("USERNAME",privUsersEntity.getUname()).iterate();
        List<Long> list = new ArrayList<>();
        while(iterator.hasNext()){
            list.add((Long)iterator.next());
        }
        hql = "SELECT l.privilegeId FROM " +
                "PrivUsersEntity u, " +
                "PrivPrivLEntity l " +
                "WHERE u.uname = :USERNAME " +
                "AND u.userId = l.userId";
        iterator = getSession().createQuery(hql).setParameter("USERNAME",privUsersEntity.getUname()).iterate();
        while(iterator.hasNext()){
            list.add((Long)iterator.next());
        }
        return list;
    }

    @Override
    public List<PrivModelEntity> getAccessAbleModel(List<Long> privileges) {
        String hql = "FROM PrivModelEntity m WHERE m.privilegeId IN (" + StringHandler.Handle(privileges) + ")";
        return getSession().createQuery(hql, PrivModelEntity.class).list();
    }

    @Override
    public List<PrivInterfaceEntity> getAccessAbleInterface(List<Long> privileges) {
        String hql = "FROM PrivInterfaceEntity i WHERE i.privilegeId IN (" + StringHandler.Handle(privileges) + ")";
        return getSession().createQuery(hql, PrivInterfaceEntity.class).list();
    }
    @Override
    public Map<String, Long> getPrivMap(){
        String hql = "SELECT t.interfaceCode, t.privilegeId FROM PrivInterfaceEntity t";
        Iterator iterator = getSession().createQuery(hql).iterate();
        Map<String, Long> privMap = new HashMap<>();
        while (iterator.hasNext()){
            Object[] o = (Object[])iterator.next();
            privMap.put((String)o[0], (Long) o[1]);
        }
        return privMap;
    }
}
