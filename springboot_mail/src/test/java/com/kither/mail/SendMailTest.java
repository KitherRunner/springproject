package com.kither.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailTest {

    @Autowired
    private SendMailService sendMailService;

    @Test
    public void sendSimpleMail() {
        sendMailService.sendSimpleMail();
    }

    @Test
    public void sendHtmlMessage() throws Exception {
        sendMailService.sendHtmlMail();
    }

    @Test
    public void testAttachmentMail() throws Exception {
        sendMailService.sendAttachmentMail();
    }

    @Test
    public void testSendInlineMail() throws Exception {
        sendMailService.sendInlineMail();
    }

    @Test
    public void sendTemplateMail() throws Exception {
        sendMailService.senTemplateMail();
    }
}
