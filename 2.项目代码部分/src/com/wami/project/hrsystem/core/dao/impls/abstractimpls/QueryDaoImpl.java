package com.wami.project.hrsystem.core.dao.impls.abstractimpls;

import com.wami.project.hrsystem.core.dao.interfaces.AbstractQueryDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value = "QueryDao")
public abstract class QueryDaoImpl<T> extends DaoImpl<T> implements AbstractQueryDao<T> {
    private Query<T> inputParameter(Query<T> query, Map<String, Object> objectMap){
        for(Map.Entry<String, Object> entry:objectMap.entrySet()){
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query;
    }
    @Autowired
    public QueryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    @Override
    public T getDistinct(String hql, Class<T> clazz, Map<String, Object> objectMap) {
        if (objectMap.isEmpty()){
            objectMap = new HashMap<>();
        }
        Query<T> query = getSession().createQuery(hql, clazz);
        return inputParameter(query, objectMap).uniqueResult();
    }
    @Override
    public T getDistinct(String hql, Class<T> clazz) {
        return getDistinct(hql, clazz, null);
    }
    @Override
    public List<T> getList(String hql, Class<T> clazz, Map<String, Object> objectMap) {
        if (objectMap.isEmpty()){
            objectMap = new HashMap<>();
        }
        Query<T> query = getSession().createQuery(hql, clazz);
        return inputParameter(query, objectMap).list();
    }
    @Override
    public List<T> getList(String hql, Class<T> clazz) {
        return getList(hql, clazz, null);
    }
    @Override
    public Object getObject(String hql, Map<String, Object> objectMap) {
        if (objectMap.isEmpty()){
            objectMap = new HashMap<>();
        }
        Query query = getSession().createQuery(hql);
        for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.uniqueResult();
    }
    @Override
    public Object getObject(String hql) {
        return getObject(hql, null);
    }
}
