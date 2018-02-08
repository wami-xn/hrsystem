package com.wami.project.hrsystem.core.dao.impls.actualimpls;

import com.wami.project.hrsystem.core.dao.impls.abstractimpls.MessageDaoImpl;
import com.wami.project.hrsystem.core.enties.message.MsgMessageEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "LoginMessageDao")
public class LoginMessageDaoImpl extends MessageDaoImpl<MsgMessageEntity> {
    @Autowired
    public LoginMessageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
