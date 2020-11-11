package com.gp.cms.model;

import java.io.Serializable;

public class Major implements Serializable {
    private static final long serialVersionUID = -1550874079828933170L;
    /**
     * 专业id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;

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
}
