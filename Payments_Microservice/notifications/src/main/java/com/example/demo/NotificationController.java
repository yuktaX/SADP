package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping("/send")
    public String sendNotification(@RequestBody String invoiceData) {
        System.out.println("Notification triggered with Invoice Data: " + invoiceData);
        System.out.println("Sending notification to customer...");
        return "Notification sent!";
    }
}
