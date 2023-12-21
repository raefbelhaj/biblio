package tech.getarrays.bibliotheque.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@AllArgsConstructor
@Service
public class NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmailNotification(String to, String subject, String body) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        try {
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true); // Use true to enable HTML content

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}
