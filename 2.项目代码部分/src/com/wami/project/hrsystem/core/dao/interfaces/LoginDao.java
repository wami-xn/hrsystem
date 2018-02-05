package com.wami.project.hrsystem.core.dao.interfaces;

import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;

public interface LoginDao extends AbstractDao<PrivUsersEntity> {
    public void insert(PrivUsersEntity usersEntity);
    public void update(PrivUsersEntity usersEntity, String password);
    public void delete(PrivUsersEntity usersEntity);
    public Boolean check(PrivUsersEntity usersEntity);
}
