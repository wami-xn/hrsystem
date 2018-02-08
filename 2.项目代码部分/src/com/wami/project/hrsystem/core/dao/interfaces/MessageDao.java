package com.wami.project.hrsystem.core.dao.interfaces;

public interface MessageDao<T> extends AbstractDao<T> {
    public void Insert(T t);
}
