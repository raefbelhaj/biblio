package tech.getarrays.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.NotificationRequest;
import tech.getarrays.bibliotheque.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/send")
    public String sendTestNotification() {
        String to = "test@example.com";
        String subject = "Test Notification";
        String body = "This is a test notification.";

        try {
            notificationService.sendEmailNotification(to, subject, body);
            return "Notification sent successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending notification: " + e.getMessage();
        }
    }

    @PostMapping("/send-custom")
    public String sendCustomNotification(@RequestBody NotificationRequest request) {
        try {
            notificationService.sendEmailNotification(request.getTo(), request.getSubject(), request.getBody());
            return "Custom notification sent successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending custom notification: " + e.getMessage();
        }
    }
}
