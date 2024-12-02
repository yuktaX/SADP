package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping("/process")
    public String processPayment(@RequestBody String paymentRequest) {
        System.out.println("Received payment request: " + paymentRequest);
        System.out.println("Connecting to external payment gateway...");
        // Simulate external gateway interaction
        System.out.println("----EXTERNAL GATEWAY----");

        //inform notification to send notifcation
        //add result to MQ

        return "Payment processed successfully via External Gateway!";
    }
}
