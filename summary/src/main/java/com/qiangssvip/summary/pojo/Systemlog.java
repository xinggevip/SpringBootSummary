package com.qiangssvip.summary.pojo;

import java.io.Serializable;
import java.util.Date;

public class Systemlog implements Serializable {
    private Long id;

    private Date optime;

    private String ip;

    private String function;

    private String params;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", optime=").append(optime);
        sb.append(", ip=").append(ip);
        sb.append(", function=").append(function);
        sb.append(", params=").append(params);
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
        Systemlog other = (Systemlog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOptime() == null ? other.getOptime() == null : this.getOptime().equals(other.getOptime()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getFunction() == null ? other.getFunction() == null : this.getFunction().equals(other.getFunction()))
            && (this.getParams() == null ? other.getParams() == null : this.getParams().equals(other.getParams()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOptime() == null) ? 0 : getOptime().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getFunction() == null) ? 0 : getFunction().hashCode());
        result = prime * result + ((getParams() == null) ? 0 : getParams().hashCode());
        return result;
    }
}