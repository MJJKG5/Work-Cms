package com.gp.cms.model;

import java.io.Serializable;

public class Album implements Serializable {
    private static final long serialVersionUID = 9082002347236917823L;
    /**
     * 相册id
     */
    private Long id;
    /**
     * 相册名
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
