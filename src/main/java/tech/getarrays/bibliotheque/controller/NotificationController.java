package tech.getarrays.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.getarrays.bibliotheque.models.NotificationRequest;
import tech.getarrays.bibliotheque.service.NotificationService;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications/send")
    public String sendTestNotification(Model model) {
        String to = "test@example.com";
        String subject = "Test Notification";
        String body = "This is a test notification.";

        try {
            notificationService.sendEmailNotification(to, subject, body);
            model.addAttribute("message", "Notification sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Error sending notification: " + e.getMessage());
        }

        return "notification";
    }

    @PostMapping("/notifications/send-custom")
    public String sendCustomNotification(@ModelAttribute NotificationRequest request, Model model) {
        try {
            notificationService.sendEmailNotification(request.getTo(), request.getSubject(), request.getBody());
            model.addAttribute("message", "Custom notification sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Error sending custom notification: " + e.getMessage());
        }

        return "notification";
    }

    @GetMapping("/notifications/send-custom")
    public String showCustomNotificationForm(Model model) {
        model.addAttribute("notificationRequest", new NotificationRequest());
        return "notification";
    }


}
