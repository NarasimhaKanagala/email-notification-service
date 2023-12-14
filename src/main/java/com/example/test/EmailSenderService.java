package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    DataSource dataSource;
    public void sendEmail(String toEmail,
                          String subject,
                          String body){
        SimpleMailMessage sm = new SimpleMailMessage();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        System.out.println("Inthe controller");
        String sql = "SELECT body FROM email WHERE body = ?";

      String result  = jdbcTemplate.queryForObject(
                sql, new Object[]{"test123"}, String.class);
        System.out.println(result);
        sm.setFrom(toEmail);
        sm.setTo(toEmail);
        sm.setText(body);
        sm.setSubject(subject);
        mailSender.send(sm);
        System.out.println("mail sent successfully................");
    }
}
