package com.wami.project.hrsystem.core.dao.impls.actualimpls;


import com.wami.project.hrsystem.core.dao.impls.abstractimpls.UpdateDaoImpl;
import com.wami.project.hrsystem.core.dao.interfaces.NormalDao;
import com.wami.project.hrsystem.core.enties.privs.PrivPrivLEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Deprecated
@Repository
public class TestImpl extends UpdateDaoImpl<PrivPrivLEntity> implements NormalDao<PrivPrivLEntity>{
    @Autowired
    public TestImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
