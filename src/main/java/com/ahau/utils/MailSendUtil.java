package com.ahau.utils;

import com.ahau.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.net.InetAddress;

@Component
public class MailSendUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${lance.mail.sender}")
    private String MAIL_SENDER;

    @Value("${lance.mail.url}")
    private String url;

    public void sendHTMLMail(/*收件人*/String recipient,/*激活码*/String code,/*用户信息*/ User user) throws Exception {
        MimeMessage mimeMailMessage = null;
        mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
        mimeMessageHelper.setFrom(MAIL_SENDER);
        mimeMessageHelper.setTo(recipient);
        mimeMessageHelper.setSubject("注册认证");
        StringBuilder stringBuilder = new StringBuilder();
        String url=this.url+"/user/active?code="+code;
        stringBuilder.append("<div style=\"text-align: center\"><h1>注册认证</h1><h3>用户名："+user.getUserName()+"</h3><h3>注册时间："+user.getCreateTime()+"</h3>" +
                "<a href="+url+">激活账号</a>" +
                "</div>");
        mimeMessageHelper.setText(stringBuilder.toString(), true);
        javaMailSender.send(mimeMailMessage);

    }
}
