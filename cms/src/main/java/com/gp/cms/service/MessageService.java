package com.gp.cms.service;

import com.gp.cms.model.Message;
import com.gp.cms.model.entity.ResApi;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface MessageService {
    /**
     * 查询留言
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @param request  请求
     * @return
     */
    ResApi<Map<String, Object>> queryMessage(Integer pageNo, Integer pageSize, HttpServletRequest request);

    /**
     * 添加留言
     *
     * @param message 留言
     * @param request 请求
     * @return
     */
    ResApi<String> addMessage(Message message, HttpServletRequest request);

    /**
     * 删除留言
     *
     * @param id      留言id
     * @param request 请求
     * @return
     */
    ResApi<String> deleteMessage(Long id, HttpServletRequest request);
}
