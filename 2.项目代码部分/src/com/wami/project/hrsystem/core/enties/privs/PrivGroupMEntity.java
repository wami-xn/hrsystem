package com.wami.project.hrsystem.core.enties.privs;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRIV_GROUP_M", schema = "C##HRMGR")
public class PrivGroupMEntity {
    private long groupId;
    private String groupName;

    @Id
    @SequenceGenerator(name = "T_USER_GENERATOR", sequenceName = "PRIV_GROUP_M_ID_SEQ", initialValue = 100000000, allocationSize = 200000000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_USER_GENERATOR")
    @Column(name = "GROUP_ID")
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "GROUP_NAME")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivGroupMEntity that = (PrivGroupMEntity) o;
        return groupId == that.groupId &&
                Objects.equals(groupName, that.groupName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(groupId, groupName);
    }
}
