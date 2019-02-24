package com.ahau.utils;

import com.ahau.entity.system.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class MailSendUtil {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String MAIL_SENDER;

    @Autowired
    public MailSendUtil(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendHTMLMail(/*收件人*/String recipient,/*激活码*/String code,/*用户信息*/ User user) throws Exception {
        MimeMessage mimeMailMessage = null;
        mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
        mimeMessageHelper.setFrom(MAIL_SENDER);
        mimeMessageHelper.setTo(recipient);
        mimeMessageHelper.setSubject("注册认证");
        String url= "http://47.106.74.107:8081/user/active?code="+code;
        String stringBuilder = ("<div style=\"text-align: center\"><h1>注册认证</h1><h3>用户名：" + user.getUserName() + "</h3><h3>注册时间：" + user.getCreateTime() + "</h3>" +
                "<a href=" + url + ">激活账号</a>" +
                "</div>");
        mimeMessageHelper.setText(stringBuilder, true);
        javaMailSender.send(mimeMailMessage);

    }
}
