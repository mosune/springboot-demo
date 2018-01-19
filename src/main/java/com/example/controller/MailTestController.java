package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * FileName: MailTest
 *
 * @author gcg
 * @create 2017/12/12 10:36
 * Description: E-mail test demo
 * History:
 **/
@RestController
@RequestMapping(value = "mail")
public class MailTestController {

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "sendMail", method = RequestMethod.POST)
    public String sendSimpleMail(@RequestParam Map<String, Object> map) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("526409252@qq.com");
        message.setTo((String) map.get("address"));
        message.setSubject((String) map.get("subject"));
        message.setText((String) map.get("text"));
        mailSender.send(message);
        return "success";
    }

    @RequestMapping(value = "sendAttachmentsMail", method = RequestMethod.POST)
    public String sendAttachmentsMail(@RequestParam Map<String, Object> map) throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("526409252@qq.com");
        helper.setTo((String) map.get("address"));
        helper.setSubject((String) map.get("subject"));
        helper.setText((String) map.get("text"));

        FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/a.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);
        return "success";
    }

    @RequestMapping(value = "sendWithAttachShow", method = RequestMethod.POST)
    public String sendAttachMailAndShow(@RequestParam Map<String, Object> map) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("526409252@qq.com");
        helper.setTo((String) map.get("address"));
        helper.setSubject((String) map.get("subject"));
        helper.setText("<html><body><img src=\"cid:jielun\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/a.jpg"));
        helper.addInline("jielun", file);

        mailSender.send(mimeMessage);
        return "success";
    }

}
