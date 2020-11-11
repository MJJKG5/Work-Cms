package com.gp.cms.controller;

import com.gp.cms.model.Student;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api")
public class SignController {
    @Autowired
    private SignService signService;

    /**
     * 注册
     *
     * @param student 学生
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ResApi<String> signUp(@RequestBody Student student, HttpServletRequest request) {
        return signService.signUp(student, request);
    }

    /**
     * 登录
     *
     * @param student 学生
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public ResApi<Map<String, Object>> signIn(@RequestBody Student student, HttpServletRequest request) {
        return signService.signIn(student, request);
    }

    /**
     * 注销
     *
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "signOut", method = RequestMethod.GET)
    public ResApi<String> signOut(HttpServletRequest request) {
        return signService.signOut(request);
    }
}
