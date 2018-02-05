package com.wami.project.hrsystem.core.enties.privs;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRIV_PRIV_L", schema = "C##HRMGR")
public class PrivPrivLEntity {
    private Long flowId;
    private Long userId;
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
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        PrivPrivLEntity that = (PrivPrivLEntity) o;
        return Objects.equals(flowId, that.flowId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(privilegeId, that.privilegeId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flowId, userId, privilegeId);
    }
}
