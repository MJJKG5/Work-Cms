package com.gp.cms.service;

import com.gp.cms.model.Student;
import com.gp.cms.model.entity.ResApi;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface SignService {
    /**
     * 注册
     *
     * @param student 学生
     * @param request 请求
     * @return
     */
    ResApi<String> signUp(Student student, HttpServletRequest request);

    /**
     * 登录
     *
     * @param student 学生
     * @param request 请求
     * @return
     */
    ResApi<Map<String, Object>> signIn(Student student, HttpServletRequest request);

    /**
     * 注销
     *
     * @param request 请求
     * @return
     */
    ResApi<String> signOut(HttpServletRequest request);
}
