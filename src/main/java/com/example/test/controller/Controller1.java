package com.example.test.controller;

import com.example.test.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

import org.springframework.core.env.Environment;


@RestController
@RequestMapping("/notificationService")


public class Controller1 {

    @Autowired
    DataSource dataSource;
    @Autowired
    private Environment environment;

    @Autowired
    EmailSenderService emailSenderService;

    @GetMapping(value = "/health")
    public String health(String toEmail, String status) {
        return "app is up ";
    }

    @GetMapping(value = "/sendEmail")
    public String sendEmail() {
        emailSenderService.sendEmail();
        return "Email sent successfully";

    }
}
