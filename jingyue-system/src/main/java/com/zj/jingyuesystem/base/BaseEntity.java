package com.zj.jingyuesystem.base;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

    private Date updateTime;
    private Date createTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
