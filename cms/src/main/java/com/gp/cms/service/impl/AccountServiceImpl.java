package com.gp.cms.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.gp.cms.common.exception.LogicException;
import com.gp.cms.common.utils.Check;
import com.gp.cms.common.utils.Session;
import com.gp.cms.model.Account;
import com.gp.cms.model.Student;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.repository.StudentMapper;
import com.gp.cms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询账户
     *
     * @param request 请求
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryAccount(HttpServletRequest request) {
        // 获取学生id
        Long accountId = new Session(request).accountId();
        // 查询学生
        Student student = studentMapper.queryById(accountId);

        Map<String, Object> map = new HashMap<>();
        map.put("student", student);
        return new ResApi<>(map);
    }

    /**
     * 修改密码
     *
     * @param account 账户
     * @param request 请求
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> updatePassword(Account account, HttpServletRequest request) {
        // 获取会话
        Session session = new Session(request);
        // 修改密码(旧密码+新密码)
        if (StringUtils.isEmpty(account.getCode())) {
            Check.isNull(account.getOldPassword(), "oldPassword 参数为空");
            Check.isNull(account.getNewPassword(), "newPassword 参数为空");
            // 获取账户id
            Long accountId = session.accountId();
            // 验证账户
            Student result = studentMapper.queryById(accountId);
            if (result != null) {
                // 旧密码加密(MD5)
                String oldPassword = SecureUtil.md5(result.getEmail() + account.getOldPassword());
                // 验证旧密码
                if (!result.getPassword().equals(oldPassword)) {
                    throw new LogicException("旧密码错误");
                }
                // 密码加密(MD5)
                String password = SecureUtil.md5(result.getEmail() + account.getNewPassword());
                // 修改密码
                studentMapper.updateById(accountId, password);
            }
        }

        // 忘记密码(验证码+密码)
        else {
            Check.isNull(account.getEmail(), "email 参数为空");
            Check.isNull(account.getPassword(), "password 参数为空");
            // 检查验证码
            String code = session.code();
            if (!code.equals(account.getCode())) {
                throw new LogicException("验证码错误");
            }
            // 密码加密(MD5)
            String password = SecureUtil.md5(account.getEmail() + account.getPassword());
            // 修改密码
            studentMapper.updateByEmail(account.getEmail(), password);
        }

        return new ResApi<>();
    }
}
