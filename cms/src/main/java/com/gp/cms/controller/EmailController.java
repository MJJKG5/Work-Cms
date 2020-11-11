package com.gp.cms.controller;

import cn.hutool.core.util.RandomUtil;
import com.gp.cms.common.utils.Check;
import com.gp.cms.common.utils.Session;
import com.gp.cms.model.entity.ResApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api")
public class EmailController {
    @Value("${email.from}")
    String from;
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送邮件
     *
     * @param to      收件人
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "email", method = RequestMethod.POST)
    public ResApi<String> email(@RequestParam String to, HttpServletRequest request) {
        Check.isNull(to, "to 参数为空");
        // 生成验证码
        int code = RandomUtil.randomInt(1000, 9999);
        // 发送邮件
        sendEmail(to, code);
        // 存储验证码
        new Session(request).set("email_" + request.getSession().getId(), code);

        return new ResApi<>();
    }

    /**
     * 发送邮件
     *
     * @param to   收件人
     * @param code 验证码
     */
    private void sendEmail(String to, int code) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            // 发件人
            helper.setFrom(from);
            // 收件人
            helper.setTo(to);
            // 主题
            helper.setSubject("验证码");
            // 内容
            helper.setText("您的验证为:" + code);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // 发送
        javaMailSender.send(message);
    }
}