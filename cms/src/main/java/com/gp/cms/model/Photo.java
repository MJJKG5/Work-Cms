package com.gp.cms.model;

import java.io.Serializable;

public class Photo implements Serializable {
    private static final long serialVersionUID = -2051460218092994109L;
    /**
     * 照片id
     */
    private Long id;
    /**
     * 代理地址
     */
    private String proxyUrl;
    /**
     * 源文件地址
     */
    private String originUrl;
    /**
     * 班级id
     */
    private Long classId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProxyUrl() {
        return proxyUrl;
    }

    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}
