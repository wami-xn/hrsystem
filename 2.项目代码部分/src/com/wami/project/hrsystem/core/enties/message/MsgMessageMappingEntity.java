package com.wami.project.hrsystem.core.enties.message;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MSG_MESSAGE_MAPPING", schema = "C##HRMGR")
public class MsgMessageMappingEntity {
    private Long flowId;
    private Long messageId;
    private Long userId;

    @Id
    @Column(name = "FLOW_ID")
    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    @Basic
    @Column(name = "MESSAGE_ID")
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgMessageMappingEntity that = (MsgMessageMappingEntity) o;
        return Objects.equals(flowId, that.flowId) &&
                Objects.equals(messageId, that.messageId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flowId, messageId, userId);
    }
}
