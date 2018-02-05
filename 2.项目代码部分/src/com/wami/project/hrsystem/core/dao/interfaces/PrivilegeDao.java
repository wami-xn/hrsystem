package com.wami.project.hrsystem.core.dao.interfaces;

import com.wami.project.hrsystem.core.enties.privs.PrivGroupDEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivInterfaceEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivModelEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;

import java.util.List;

public interface PrivilegeDao extends AbstractDao<PrivGroupDEntity> {
     public List<Long> getAllPrivilege(PrivUsersEntity privUsersEntity);
     public List<PrivModelEntity> getAccessAbleModel(List<Long> privileges);
     public List<PrivInterfaceEntity> getAccessAbleInterface(List<Long> privileges);
}
