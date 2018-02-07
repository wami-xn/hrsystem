package com.wami.project.hrsystem.core.enties.privs;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRIV_INTERFACE", schema = "C##HRMGR")
public class PrivInterfaceEntity {
    private Short interfaceId;
    private Long privilegeId;
    private Short modelId;
    private String interfaceName;
    private String enableFlag;
    @Basic
    @Column(name = "INTERFACE_CODE")
    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    private String interfaceCode;

    @Id
    @Column(name = "INTERFACE_ID")
    public Short getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Short interfaceId) {
        this.interfaceId = interfaceId;
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
    @Column(name = "MODEL_ID")
    public Short getModelId() {
        return modelId;
    }

    public void setModelId(Short modelId) {
        this.modelId = modelId;
    }

    @Basic
    @Column(name = "INTERFACE_NAME")
    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
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
        PrivInterfaceEntity that = (PrivInterfaceEntity) o;
        return Objects.equals(interfaceId, that.interfaceId) &&
                Objects.equals(privilegeId, that.privilegeId) &&
                Objects.equals(modelId, that.modelId) &&
                Objects.equals(interfaceName, that.interfaceName) &&
                Objects.equals(enableFlag, that.enableFlag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(interfaceId, privilegeId, modelId, interfaceName, enableFlag);
    }

    @Override
    public String toString() {
        return "PrivInterfaceEntity{" +
                "interfaceId=" + interfaceId +
                ", privilegeId=" + privilegeId +
                ", modelId=" + modelId +
                ", interfaceName='" + interfaceName + '\'' +
                ", enableFlag='" + enableFlag + '\'' +
                ", interfaceCode='" + interfaceCode + '\'' +
                '}';
    }
}
