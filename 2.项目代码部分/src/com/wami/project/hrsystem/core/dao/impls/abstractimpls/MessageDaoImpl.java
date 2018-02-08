package com.wami.project.hrsystem.core.dao.impls.abstractimpls;

import com.wami.project.hrsystem.core.dao.interfaces.MessageDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "MessageDao")
public abstract class MessageDaoImpl<T> extends DaoImpl<T> implements MessageDao<T> {
    @Autowired
    public MessageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    @Override
    public void Insert(T t) {
        getSession().save(t);
    }
}
