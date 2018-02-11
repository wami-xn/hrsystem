package com.wami.project.hrsystem.core.dao.impls.abstractimpls;

import com.wami.project.hrsystem.core.dao.interfaces.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public abstract class DaoImpl<T> implements AbstractDao<T> {
    private final SessionFactory sessionFactory;
    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

}
