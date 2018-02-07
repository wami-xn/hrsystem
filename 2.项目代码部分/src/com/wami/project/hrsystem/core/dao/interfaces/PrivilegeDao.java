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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
     public Map<String, Long> getPrivMap();
=======
>>>>>>> parent of c77bf88... 1.0-001-0
=======
>>>>>>> parent of c77bf88... 1.0-001-0
=======
>>>>>>> parent of c77bf88... 1.0-001-0
=======
     public Map<Long, String> getPrivMap();
>>>>>>> parent of 2d692c5... 1.0-001-1
=======
>>>>>>> parent of c77bf88... 1.0-001-0
}
