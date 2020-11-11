package com.gp.cms.model;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 9015120379218799389L;
    /**
     * 留言id
     */
    private Long id;
    /**
     * 发件人
     */
    private Long from;
    /**
     * 收件人
     */
    private Long to;
    /**
     * 留言内容
     */
    private String body;
    /**
     * 留言时间
     */
    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
