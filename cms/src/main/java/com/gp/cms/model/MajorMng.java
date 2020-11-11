package com.gp.cms.model;

import java.io.Serializable;

public class MajorMng implements Serializable {
    private static final long serialVersionUID = -2425569028706507120L;
    /**
     * 管理id
     */
    private Long id;
    /**
     * 专业id
     */
    private Long majorId;
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

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
