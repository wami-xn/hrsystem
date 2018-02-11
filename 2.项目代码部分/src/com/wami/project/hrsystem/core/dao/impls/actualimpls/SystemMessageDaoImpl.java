package com.wami.project.hrsystem.core.dao.impls.actualimpls;

import com.wami.project.hrsystem.core.dao.impls.abstractimpls.UpdateDaoImpl;
import com.wami.project.hrsystem.core.dao.interfaces.MessageDao;
import com.wami.project.hrsystem.core.enties.message.MsgMessageSystemEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component(value = "SystemMessageDao")
@Transactional
public class SystemMessageDaoImpl extends UpdateDaoImpl<MsgMessageSystemEntity> implements MessageDao<MsgMessageSystemEntity> {
    @Autowired
    public SystemMessageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<MsgMessageSystemEntity> getMessage(PrivUsersEntity privUsersEntity) {
        String hql = "SELECT MsgMessageSystemEntity " +
                "FROM MsgMessageSystemEntity ms, " +
                "MsgMessageMappingEntity mm, " +
                "PrivUsersEntity  p " +
                "WHERE mm.messageId = ms.flowId " +
                "AND mm.userId = p.userId " +
                "AND p.uname = :USERNAME";
        Query<MsgMessageSystemEntity> query = getSession().createQuery(hql, MsgMessageSystemEntity.class);
        query.setParameter("USERNAME", privUsersEntity.getUname());
        return query.list();
    }

    @Override
    public List<MsgMessageSystemEntity> getAlertMessage(PrivUsersEntity privUsersEntity) {
        String hql = "SELECT MsgMessageSystemEntity " +
                "FROM MsgMessageSystemEntity ms, " +
                "MsgMessageMappingEntity mm, " +
                "PrivUsersEntity  p " +
                "WHERE mm.messageId = ms.flowId " +
                "AND mm.userId = p.userId " +
                "AND p.uname = :USERNAME " +
                "AND ms.startTime <= CURRENT_TIMESTAMP ";
        Query<MsgMessageSystemEntity> query = getSession().createQuery(hql, MsgMessageSystemEntity.class);
        query.setParameter("USERNAME", privUsersEntity.getUname());
        return query.list();
    }

    @Override
    public List<MsgMessageSystemEntity> getAllMessage() {
        return null;
    }
}
