package com.gp.cms.service;

import com.gp.cms.model.Account;
import com.gp.cms.model.entity.ResApi;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AccountService {
    /**
     * 查询账户
     *
     * @param request 请求
     * @return
     */
    ResApi<Map<String, Object>> queryAccount(HttpServletRequest request);

    /**
     * 修改密码
     *
     * @param account 账户
     * @param request 请求
     * @return
     */
    ResApi<String> updatePassword(Account account, HttpServletRequest request);
}
