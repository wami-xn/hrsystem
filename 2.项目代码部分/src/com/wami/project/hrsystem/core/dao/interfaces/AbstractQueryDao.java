package com.wami.project.hrsystem.core.dao.interfaces;

import java.util.List;
import java.util.Map;

public interface AbstractQueryDao<T> extends AbstractDao<T> {
    public T getDistinct(String hql, Class<T> clazz, Map<String, Object> objectMap);
    public T getDistinct(String hql, Class<T> clazz);
    public List<T> getList(String hql, Class<T> clazz, Map<String, Object> objectMap);
    public List<T> getList(String hql, Class<T> clazz);
    public Object getObject(String hql, Map<String, Object> objectMap);
    public Object getObject(String hql);
}
