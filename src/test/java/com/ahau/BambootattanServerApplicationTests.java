package com.ahau;

import com.ahau.utils.MailSendUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BambootattanServerApplicationTests {

//    private MailSendUtil mailSendUtil=new MailSendUtil();
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//    @Test
//    public void sendSimpleMail() {
//        try {
//            mailSendUtil.sendHTMLMail("1138816450@qq.com","测试");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("失败");
//        }
//    }


    @Test
    public void contextLoads() {
    }


}
