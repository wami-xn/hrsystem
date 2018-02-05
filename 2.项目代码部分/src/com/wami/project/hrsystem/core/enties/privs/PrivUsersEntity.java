package com.wami.project.hrsystem.core.enties.privs;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRIV_USERS", schema = "C##HRMGR")
public class PrivUsersEntity {
    private long userId;
    private String uname;
    private String upwd;
    @Id
    @SequenceGenerator(name = "T_USER_GENERATOR", sequenceName = "PRIV_USERS_ID_SEQ", initialValue = 100000000, allocationSize = 200000000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_USER_GENERATOR")
    @Column(name = "USER_ID")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UNAME")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "UPWD")
    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivUsersEntity that = (PrivUsersEntity) o;
        return Objects.equals(uname, that.uname) &&
                Objects.equals(upwd, that.upwd);
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (uname != null ? uname.hashCode() : 0);
        result = 31 * result + (upwd != null ? upwd.hashCode() : 0);
        return result;
    }
}
