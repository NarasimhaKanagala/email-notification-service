package com.example.test.scheduler;

import com.example.test.service.EmailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableScheduling
public class SendEmailScheduler {



    @Autowired
    EmailSenderService emailSenderService;

    @Scheduled(cron = "* * * * * *")
    /*if application properties does not contain change to default time*/
    public void reportCurrentTime() {
        emailSenderService.sendEmail();
        System.out.println(" cron job ran successfully");
    }
}
