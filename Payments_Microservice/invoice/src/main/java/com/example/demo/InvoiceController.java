package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @PostMapping("/generate")
    public String generateInvoice(@RequestBody String serviceProviderRequest) {
        System.out.println("Received data from Service Provider: " + serviceProviderRequest);
        System.out.println("Generating invoice...");
        return "Invoice generated successfully!";
    }
}
