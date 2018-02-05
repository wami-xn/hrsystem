package com.wami.project.hrsystem.core.dao.impls.abstractimpls;

import com.wami.project.hrsystem.core.dao.interfaces.NormalDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository(value = "UpdateDao")
public abstract class UpdateDaoImpl<T> extends QueryDaoImpl<T> implements NormalDao<T> {
    @Autowired
    public UpdateDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    @Override
    public void insertOrUpdate(List<T> list){
        for(T t: list){
            getSession().save(t);
        }
    }

    @Override
    public void delete(List<T> list) {
        for(T t: list){
            getSession().delete(t);
        }
    }

    @Override
    public void insertOrUpdate(T t) {
        this.insertOrUpdate(Collections.singletonList(t));
    }

    @Override
    public void delete(T t) {
        this.delete(Collections.singletonList(t));
    }

    @Override
    public Integer update(String hql) {
        return this.update(hql, null);
    }

    @Override
    public Integer update(String hql, Map<String, Object> objectMap) {
        if (objectMap.isEmpty()){
            objectMap = new HashMap<>();
        }
        Query query = getSession().createQuery(hql);
        for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.executeUpdate();
    }
}
