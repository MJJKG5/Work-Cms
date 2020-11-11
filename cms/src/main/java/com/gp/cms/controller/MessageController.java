package com.gp.cms.controller;

import com.gp.cms.model.Message;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api")
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 查询留言
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @param request  请求
     * @return
     */
    @RequestMapping(value = "message", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryMessage(@RequestParam Integer pageNo,
                                                    @RequestParam Integer pageSize,
                                                    HttpServletRequest request) {
        return messageService.queryMessage(pageNo, pageSize, request);
    }

    /**
     * 添加留言
     *
     * @param message 留言
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "message", method = RequestMethod.POST)
    public ResApi<String> addMessage(@RequestBody Message message, HttpServletRequest request) {
        return messageService.addMessage(message, request);
    }

    /**
     * 删除留言
     *
     * @param id      留言id
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "message", method = RequestMethod.DELETE)
    public ResApi<String> deleteMessage(@RequestParam Long id, HttpServletRequest request) {
        return messageService.deleteMessage(id, request);
    }
}
