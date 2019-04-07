package com.kither.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.UUID;

@Component
public class SendMailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.to}")
    private String to;

    // 普通邮件
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("2019407测试加简单邮件");
        message.setText("这是20190407号晚上测试的一封简单邮件");
        message.setSentDate(new Date());
        message.setTo(to);
        message.setFrom(from);
        mailSender.send(message);
    }

    // 带html内容的邮件
    public void sendHtmlMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("20190407测试带html内容的邮件");
        helper.setText("<h1 style='color:red;'>这是20190407晚上测试的带html内容的邮件</h1>", true);
        helper.setTo(to);
        helper.setFrom(from);
        helper.setSentDate(new Date());
        mailSender.send(mimeMessage);
    }

    // 带静态资源的邮件
    public void sendInlineMail() throws Exception {
        String rscId = UUID.randomUUID().toString();
        String rscId2 = UUID.randomUUID().toString();

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("20190407测试带静态资源的邮件");
        helper.addInline(rscId2, new File("E:\\zhaoliying.jpg"));
        helper.addInline(rscId, new File("E:\\钟汉良.jpg"));
        helper.setText("<h1 style='color:red;'>这是20190407晚上测试的带静态资源的邮件</h1><br /><img src='cid:" + rscId + "'/><br /><img src='cid:" + rscId2 + "'/>", true);
        mailSender.send(mimeMessage);
    }

    // 带附件的邮件
    public void sendAttachmentMail() throws Exception {
        String fileSrc = "E:/project/ideaSpringBoot/springproject/springboot_mail/src/main/resources/test.txt";
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSentDate(new Date());
        helper.setTo(to);
        helper.setSubject("20190407测试带附件的邮件");
        helper.setText("<h1 style='color:red;'>这是20190407晚上测试的带附件的邮件</h1>", true);
        helper.addAttachment("20190407测试附件", new File(fileSrc));
        helper.setFrom(from);
        mailSender.send(mimeMessage);
    }

    public void senTemplateMail() throws Exception {
        Context context = new Context();
        context.setVariable("userId", "1");
        // 模板引擎解析thymeleaf
        String process = templateEngine.process("mailTemplate", context);

        // 发送html邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject("激活邮件");
        helper.setText(process, true);
        helper.setSentDate(new Date());
        mailSender.send(mimeMessage);
    }
}
