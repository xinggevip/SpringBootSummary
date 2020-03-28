package com.qiangssvip.summary.pojo;

import java.io.Serializable;

public class EmployeeRoleRelKey implements Serializable {
    private Long eid;

    private Long rid;

    private static final long serialVersionUID = 1L;

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eid=").append(eid);
        sb.append(", rid=").append(rid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EmployeeRoleRelKey other = (EmployeeRoleRelKey) that;
        return (this.getEid() == null ? other.getEid() == null : this.getEid().equals(other.getEid()))
            && (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEid() == null) ? 0 : getEid().hashCode());
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        return result;
    }
}