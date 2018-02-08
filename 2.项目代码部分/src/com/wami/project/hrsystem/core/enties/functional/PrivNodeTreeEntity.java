package com.wami.project.hrsystem.core.enties.functional;

import com.wami.project.hrsystem.core.enties.privs.PrivInterfaceEntity;
import com.wami.project.hrsystem.core.enties.privs.PrivModelEntity;

import java.util.List;
import java.util.Map;

public class PrivNodeTreeEntity {
    private Map<PrivModelEntity, List<PrivInterfaceEntity>> privNodeTree;

    public PrivNodeTreeEntity(Map<PrivModelEntity, List<PrivInterfaceEntity>> privNodeTree) {
        this.privNodeTree = privNodeTree;
    }

    public Map<PrivModelEntity, List<PrivInterfaceEntity>> getPrivNodeTree() {
        return privNodeTree;
    }
}
