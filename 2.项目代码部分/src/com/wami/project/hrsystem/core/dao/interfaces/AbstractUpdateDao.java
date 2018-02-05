package com.wami.project.hrsystem.core.dao.interfaces;

import java.util.List;
import java.util.Map;

public interface AbstractUpdateDao<T> extends AbstractQueryDao<T> {
    public void insertOrUpdate(T t);
    public void delete(T t);
    public void insertOrUpdate(List<T> list);
    public void delete(List<T> list);
}
