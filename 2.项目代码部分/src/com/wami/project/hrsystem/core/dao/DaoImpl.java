package com.wami.project.hrsystem.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DaoImpl {
    private final SessionFactory sessionFactory;
    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

}
