package com.gp.cms.controller;

import com.gp.cms.model.Account;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 查询账户
     *
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "account", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryAccount(HttpServletRequest request) {
        return accountService.queryAccount(request);
    }

    /**
     * 修改密码
     *
     * @param account 账户
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "update/password", method = RequestMethod.PUT)
    public ResApi<String> updatePassword(@RequestBody Account account, HttpServletRequest request) {
        return accountService.updatePassword(account, request);
    }
}
