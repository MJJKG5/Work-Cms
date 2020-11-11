package com.gp.cms.model;

import java.io.Serializable;

public class Class implements Serializable {
    private static final long serialVersionUID = -4483930554716223256L;
    /**
     * 班级id
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
    /**
     * 院系id
     */
    private Long departmentId;

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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
