package com.gp.cms.service.impl;

import com.gp.cms.common.utils.Check;
import com.gp.cms.common.utils.Session;
import com.gp.cms.model.Message;
import com.gp.cms.model.entity.Page;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.repository.MessageMapper;
import com.gp.cms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询留言
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @param request  请求
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryMessage(Integer pageNo, Integer pageSize, HttpServletRequest request) {
        // 获取账户id
        Long accountId = new Session(request).accountId();
        // 查询数量
        Long total = messageMapper.count(accountId);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询留言
        List<Message> messages = messageMapper.queryByList(accountId, page);

        Map<String, Object> map = new HashMap<>();
        map.put("messages", messages);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 添加留言
     *
     * @param message 留言
     * @return
     */
    @Override
    public ResApi<String> addMessage(Message message, HttpServletRequest request) {
        Check.isNull(message.getFrom(), "from 参数为空");
        Check.isNull(message.getTo(), "to 参数为空");
        Check.isNull(message.getBody(), "body 参数为空");
        // 获取账户id
        Long accountId = new Session(request).accountId();
        // 设置账户id
        message.setFrom(accountId);
        // 添加留言
        messageMapper.add(message);
        // 通知

        return new ResApi<>();
    }

    /**
     * 删除留言
     *
     * @param id      留言id
     * @param request 请求
     * @return
     */
    @Override
    public ResApi<String> deleteMessage(Long id, HttpServletRequest request) {
        Check.isNull(id, "id 参数为空");
        // 获取账户id
        Long accountId = new Session(request).accountId();
        // 删除留言
        messageMapper.delete(id);

        return new ResApi<>();
    }
}
