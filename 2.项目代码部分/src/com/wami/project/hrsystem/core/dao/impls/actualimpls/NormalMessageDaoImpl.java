package com.wami.project.hrsystem.core.dao.impls.actualimpls;

import com.wami.project.hrsystem.core.dao.impls.abstractimpls.UpdateDaoImpl;
import com.wami.project.hrsystem.core.dao.interfaces.MessageDao;
import com.wami.project.hrsystem.core.enties.message.MsgMessageEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component(value = "MessageDao")
@Transactional
public class NormalMessageDaoImpl extends UpdateDaoImpl<MsgMessageEntity> implements MessageDao<MsgMessageEntity> {
    @Autowired
    public NormalMessageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    @Override
    public List<MsgMessageEntity> getMessage(PrivUsersEntity privUsersEntity) {
        String hql = "SELECT MsgMessageEntity " +
                "FROM MsgMessageEntity m, " +
                "MsgMessageMappingEntity mm, " +
                "PrivUsersEntity  p " +
                "WHERE mm.messageId = m.flowId " +
                "AND mm.userId = p.userId " +
                "AND p.uname = :USERNAME";
        Query<MsgMessageEntity> query = getSession().createQuery(hql, MsgMessageEntity.class);
        query.setParameter("USERNAME", privUsersEntity.getUname());
        return query.list();
    }
    @Override
    public List<MsgMessageEntity> getAlertMessage(PrivUsersEntity privUsersEntity) {
        String hql = "SELECT MsgMessageEntity " +
                "FROM MsgMessageEntity m, " +
                "MsgMessageMappingEntity mm, " +
                "PrivUsersEntity  p " +
                "WHERE mm.messageId = m.flowId " +
                "AND mm.userId = p.userId " +
                "AND p.uname = :USERNAME " +
                "AND m.enableFlag='Y' " +
                "AND m.suppressDate <= CURRENT_TIMESTAMP";
        Query<MsgMessageEntity> query = getSession().createQuery(hql, MsgMessageEntity.class);
        query.setParameter("USERNAME", privUsersEntity.getUname());
        List<MsgMessageEntity> messageEntities = query.list();
        for(MsgMessageEntity msgMessageEntity : messageEntities){
            if(msgMessageEntity.getOnceFlag().equals("Y")) {
                msgMessageEntity.setEnableFlag("N");
                getSession().save(msgMessageEntity);
            }
        }
        return messageEntities;
    }

    @Override
    public List<MsgMessageEntity> getAllMessage() {
        return getList("FROM MsgMessageEntity", MsgMessageEntity.class);
    }
    @Override
    public void delete(MsgMessageEntity msgMessageEntity){
        super.delete(msgMessageEntity);
    }
    @Override
    public void insertOrUpdate(MsgMessageEntity msgMessageEntity){
        super.insertOrUpdate(msgMessageEntity);
    }
}
