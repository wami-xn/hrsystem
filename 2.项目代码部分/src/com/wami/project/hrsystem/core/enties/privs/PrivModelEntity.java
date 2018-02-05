package com.wami.project.hrsystem.core.enties.privs;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRIV_MODEL", schema = "C##HRMGR", catalog = "")
public class PrivModelEntity {
    private Short modelId;
    private Long privilegeId;
    private String midelName;
    private String enableFlag;

    @Id
    @Column(name = "MODEL_ID")
    public Short getModelId() {
        return modelId;
    }

    public void setModelId(Short modelId) {
        this.modelId = modelId;
    }

    @Basic
    @Column(name = "PRIVILEGE_ID")
    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    @Basic
    @Column(name = "MIDEL_NAME")
    public String getMidelName() {
        return midelName;
    }

    public void setMidelName(String midelName) {
        this.midelName = midelName;
    }

    @Basic
    @Column(name = "ENABLE_FLAG")
    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivModelEntity that = (PrivModelEntity) o;
        return Objects.equals(modelId, that.modelId) &&
                Objects.equals(privilegeId, that.privilegeId) &&
                Objects.equals(midelName, that.midelName) &&
                Objects.equals(enableFlag, that.enableFlag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(modelId, privilegeId, midelName, enableFlag);
    }
}
