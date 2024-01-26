package com.example.test.service;

import com.example.test.utils.EmployeeRowMapper;
import com.example.test.dto.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    DataSource dataSource;
    @Autowired
    private Environment environment;
    private JdbcTemplate jdbcTemplate;
    @Value("${spring.mail.username}") private String sender;


//    public Void getEmployee() {


//    public void sendEmail(String toEmail,
//                          String subject,
//                          String body){



    public void sendEmail() {


        SimpleMailMessage sm = new SimpleMailMessage();

        String status = "N";
        String sql = "select * from email_text where status = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = {status};
        List<EmailDetails> list = jdbcTemplate.query(sql, args, new EmployeeRowMapper());
        System.out.println(" list from results" + list);
        String updateQuery = "update email_text set status = 'Y'  where id = ?";
        for (EmailDetails obj : list) {
            System.out.println("DB DATA " + obj);
            sm.setFrom(sender);

            System.out.println("manoj");
            System.out.println(""+ obj.getToEmail());
            sm.setTo(obj.getToEmail().trim());
            sm.setText(obj.getBody());

//            props.put("mail.smtp.host", m_sending_host);
//            props.put("mail.smtp.auth", "true");



            mailSender.send(sm);
            System.out.println("indivisal mail sent , now updating db status to Y for those records");
            jdbcTemplate.update(updateQuery, obj.getId());
            System.out.println("record has been updated........................" + obj.getId());
        }
        System.out.println("final mail sent for all the N records successfully................");
    }
}
