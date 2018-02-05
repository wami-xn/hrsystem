package com.wami.project.hrsystem.core.enties.privs;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRIV_GROUP_D", schema = "C##HRMGR")
public class PrivGroupDEntity {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivGroupDEntity that = (PrivGroupDEntity) o;
        return userId == that.userId &&
                flowId == that.flowId &&
                groupId == that.groupId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, flowId, groupId);
    }

    @Column(name="USER_ID")
    @Basic
    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    private long userId;
    private long flowId;
    @Column(name="GROUP_ID")
    @Basic
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    private long groupId;

    @Id
    @SequenceGenerator(name = "T_USER_GENERATOR", sequenceName = "PRIV_GROUP_D_ID_SEQ", initialValue = 100000000, allocationSize = 200000000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_USER_GENERATOR")
    @Column(name = "FLOW_ID")
    public long getFlowId() {
        return flowId;
    }

    public void setFlowId(long flowId) {
        this.flowId = flowId;
    }


}
