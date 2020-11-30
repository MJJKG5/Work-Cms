package com.gp.cms.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.gp.cms.common.exception.LogicException;
import com.gp.cms.common.utils.Check;
import com.gp.cms.common.utils.Session;
import com.gp.cms.model.Student;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.repository.StudentMapper;
import com.gp.cms.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service("signService")
public class SignServiceImpl implements SignService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 注册
     *
     * @param student 学生
     * @param request 请求
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> signUp(Student student, HttpServletRequest request) {
        Check.isNull(student.getName(), "name 参数为空");
        Check.isNull(student.getSex(), "sex 参数为空");
        Check.isNull(student.getAge(), "age 参数为空");
        Check.isNull(student.getEmail(), "email 参数为空");
        Check.isNull(student.getPassword(), "password 参数为空");
        Check.isNull(student.getCode(), "code 参数为空");
        // 验证 Email
        Student result = studentMapper.queryByEmail(student.getEmail());
        if (result != null) {
            throw new LogicException("Email 已注册");
        }
        // 密码加密(MD5)
        String password = SecureUtil.md5(student.getEmail() + student.getPassword());
        // 设置密码
        student.setPassword(password);
        // 添加学生
        studentMapper.add(student);

        return new ResApi<>();
    }

    /**
     * 登录
     *
     * @param student 学生
     * @param request 请求
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> signIn(Student student, HttpServletRequest request) {
        Check.isNull(student.getEmail(), "email 参数为空");
        Check.isNull(student.getPassword(), "password 参数为空");
        // 验证账户
        Student result = studentMapper.queryByEmail(student.getEmail());
        if (result == null) {
            throw new LogicException("Email 未注册或错误");
        }
        // 密码加密(MD5)
        String password = SecureUtil.md5(student.getEmail() + student.getPassword());
        if (!password.equals(result.getPassword())) {
            throw new LogicException("Email 或密码错误");
        }
        // 存储学生id
        new Session(request).set(request.getSession().getId(), result.getId());

        Map<String, Object> map = new HashMap<>();
        map.put("id", result.getId());
        map.put("name", result.getName());
        map.put("classId", result.getClassId());
        return new ResApi<>(map);
    }

    /**
     * 注销
     *
     * @param request 请求
     * @return
     */
    @Override
    public ResApi<String> signOut(HttpServletRequest request) {
        // 注销
        new Session(request).del(request.getSession().getId());

        return new ResApi<>();
    }
}
