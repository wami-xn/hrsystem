package com.wami.project.hrsystem.core.enties.privs;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRIV_GROUP_D", schema = "C##HRMGR", catalog = "")
public class PrivGroupDEntity {
    private long flowId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivGroupDEntity that = (PrivGroupDEntity) o;
        return flowId == that.flowId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(flowId);
    }
}
