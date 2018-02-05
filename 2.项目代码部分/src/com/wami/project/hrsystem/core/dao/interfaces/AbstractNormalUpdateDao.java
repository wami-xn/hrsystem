package com.wami.project.hrsystem.core.dao.interfaces;

import java.util.Map;

public interface AbstractNormalUpdateDao<T> extends AbstractDao<T> {
    public Integer update(String hql);
    public Integer update(String hql, Map<String, Object> objectMap);
}
