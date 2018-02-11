package com.wami.project.hrsystem.core.enties.message;

import oracle.sql.TIMESTAMP;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MSG_MESSAGE", schema = "C##HRMGR")
public class MsgMessageEntity {
    private long flowId;
    private String title;
    private String detail;
    private String icon;
    private Long botton;
    private Long form;
    private String describe;
    private String onceFlag;
    private String enableFlag;
    @Basic
    @Column(name = "ENABLE_FLAG")
    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }
    @Basic
    @Column(name = "ONCE_FLAG")
    public String getOnceFlag() {
        return onceFlag;
    }

    public void setOnceFlag(String onceFlag) {
        this.onceFlag = onceFlag;
    }
    @Basic
    @Column(name = "SUPPRESS_DATE")
    public Timestamp getSuppressDate() {
        return suppressDate;
    }

    public void setSuppressDate(Timestamp suppressDate) {
        this.suppressDate = suppressDate;
    }

    private Timestamp suppressDate;

    @Id
    @SequenceGenerator(name = "T_MSG_GENERATOR", sequenceName = "PRIV_MSG_M_ID_SEQ", initialValue = 100000000, allocationSize = 200000000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_MSG_GENERATOR")
    @Column(name = "FLOW_ID")
    public long getFlowId() {
        return flowId;
    }

    public void setFlowId(long flowId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgMessageEntity that = (MsgMessageEntity) o;
        return flowId == that.flowId &&
                Objects.equals(title, that.title) &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(botton, that.botton) &&
                Objects.equals(form, that.form) &&
                Objects.equals(describe, that.describe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flowId, title, detail, icon, botton, form, describe);
    }
}
