package com.gp.cms.model;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 9015120379218799389L;
    /**
     * 留言id
     */
    private Long id;
    /**
     * 发件人id
     */
    private Long from;
    /**
     * 发件人姓名
     */
    private String fromName;
    /**
     * 收件人id
     */
    private Long to;
    /**
     * 收件人姓名
     */
    private String toName;
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

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
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
