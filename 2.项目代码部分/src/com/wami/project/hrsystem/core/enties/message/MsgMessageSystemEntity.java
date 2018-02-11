package com.wami.project.hrsystem.core.enties.message;

import oracle.sql.TIMESTAMP;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MSG_MESSAGE_SYSTEM", schema = "C##HRMGR")
public class MsgMessageSystemEntity {
    private Long flowId;
    private String title;
    private String detail;
    private String icon;
    private Long botton;
    private Long form;
    private String describe;
    private String enableFlag;
    private Timestamp startTime;
    private Timestamp endTime;

    @Id
    @Column(name = "FLOW_ID")
    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "DETAIL")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "ICON")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "BOTTON")
    public Long getBotton() {
        return botton;
    }

    public void setBotton(Long botton) {
        this.botton = botton;
    }

    @Basic
    @Column(name = "FORM")
    public Long getForm() {
        return form;
    }

    public void setForm(Long form) {
        this.form = form;
    }

    @Basic
    @Column(name = "DESCRIBE")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Basic
    @Column(name = "ENABLE_FLAG")
    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    @Basic
    @Column(name = "START_TIME")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "END_TIME")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgMessageSystemEntity that = (MsgMessageSystemEntity) o;
        return Objects.equals(flowId, that.flowId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(botton, that.botton) &&
                Objects.equals(form, that.form) &&
                Objects.equals(describe, that.describe) &&
                Objects.equals(enableFlag, that.enableFlag) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flowId, title, detail, icon, botton, form, describe, enableFlag, startTime, endTime);
    }
}
