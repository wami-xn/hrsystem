package com.wami.project.hrsystem.core.enties.privs;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRIV_GROUP_PRIV", schema = "C##HRMGR")
public class PrivGroupPrivEntity {
    private Long flowId;
    private Long groupId;
    private Long privilegeId;

    @Id
    @Column(name = "FLOW_ID")
    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    @Basic
    @Column(name = "GROUP_ID")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "PRIVILEGE_ID")
    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivGroupPrivEntity that = (PrivGroupPrivEntity) o;
        return Objects.equals(flowId, that.flowId) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(privilegeId, that.privilegeId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flowId, groupId, privilegeId);
    }
}
