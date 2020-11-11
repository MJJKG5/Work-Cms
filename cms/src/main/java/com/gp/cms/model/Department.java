package com.gp.cms.model;

import java.io.Serializable;

public class Department implements Serializable {
    private static final long serialVersionUID = -9139445978085213821L;
    /**
     * 院系id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 创建时间
     */
    private String createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
