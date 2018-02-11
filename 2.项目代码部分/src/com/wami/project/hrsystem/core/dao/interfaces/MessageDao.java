package com.wami.project.hrsystem.core.dao.interfaces;

import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;

import java.util.List;

public interface MessageDao<T> extends AbstractDao<T> {
    public void insertOrUpdate(T t);
    public List<T> getMessage(PrivUsersEntity privUsersEntity);
    public void delete(T t);
    public List<T> getAlertMessage(PrivUsersEntity privUsersEntity);
    public List<T> getAllMessage();
}
