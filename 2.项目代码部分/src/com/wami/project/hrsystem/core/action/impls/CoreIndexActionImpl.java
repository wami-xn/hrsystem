package com.wami.project.hrsystem.core.action.impls;

import com.opensymphony.xwork2.ActionContext;
import com.wami.project.hrsystem.core.action.abstractaction.AbstractActionImpl;
import com.wami.project.hrsystem.core.dao.interfaces.LoginDao;
import com.wami.project.hrsystem.core.enties.functional.PrivNodeTreeEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivInterfaceEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivModelEntity;
import com.wami.project.hrsystem.core.utils.Md5Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CoreIndexActionImpl extends AbstractActionImpl {
    @Override
    @SuppressWarnings("unchecked")
    public String execute() throws Exception {
        super.execute();
        PrivNodeTreeEntity privNodeTree = new PrivNodeTreeEntity((Map<PrivModelEntity, List<PrivInterfaceEntity>>) request.getSession().getAttribute("PrivNodeTree"));
//        context.getValueStack().push(new Md5Handler());
        for (Map.Entry<PrivModelEntity, List<PrivInterfaceEntity>> entrySet: privNodeTree.getPrivNodeTree().entrySet()){
            for (PrivInterfaceEntity privInterfaceEntity : entrySet.getValue()){
                System.out.println(privInterfaceEntity.getInterfaceName());
            }
        }
        valueStack.push(privNodeTree);
        return "success";
    }
}
