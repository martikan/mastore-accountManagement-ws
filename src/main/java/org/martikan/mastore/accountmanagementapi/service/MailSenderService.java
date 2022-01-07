package org.martikan.mastore.accountmanagementapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Email sender service.
 */
@Slf4j
@Service
public class MailSenderService {

    @Value(value = "${mail.emailAddress}")
    private String serverEmail;

    @Value(value = "${mail.emailPassword}")
    private String serverEmailPassword;

    @Async
    public void sendMail(final String to,
                         final String subject,
                         final String content) throws MessagingException {

        var props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        var session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(serverEmail, serverEmailPassword);
            }
        });

        var msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(serverEmail, false));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject(subject);
        msg.setContent(content, "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);
    }

}
