package com.gp.cms.model;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 5502915604849064656L;
    /**
     * 邮件
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 旧密码
     */
    private String oldPassword;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 验证码
     */
    private String code;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
