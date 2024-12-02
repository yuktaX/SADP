package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


//Invoice
//API Gateway forwards the request
// http://localhost:8082/invoices/generate to the Invoice Generation Service at http://localhost:8084/invoices/generate.
//Invoice Service processes the request, generates an invoice, and calls the Notification Service
// at http://localhost:8085/notifications/send with the invoice data.
//A response like Invoice generated and notification triggered: Notification sent successfully! is returned to the client.

//Payment-
//API Gateway forwards this request
// http://localhost:8082/payments/process to the Payment Service at http://localhost:8083/payments/process.
// Payment Service processes the request and interacts with the external payment gateway.
// A response like Payment processed successfully via External Gateway! is returned to the client.