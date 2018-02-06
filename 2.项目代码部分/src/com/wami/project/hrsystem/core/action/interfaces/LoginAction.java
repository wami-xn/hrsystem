package com.wami.project.hrsystem.core.action.interfaces;

import com.wami.project.hrsystem.core.enties.privs.PrivUsersEntity;

public interface LoginAction extends AbstractNormalAction<PrivUsersEntity>{
    public String loginIdentify();
}
