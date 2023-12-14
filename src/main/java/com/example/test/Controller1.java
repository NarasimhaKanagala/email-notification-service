package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/path1")


public class Controller1 {
    @Autowired
    DataSource dataSource;

//    @Autowired
//    public JdbcTemplate test2(DataSource dataSource) {
//         return jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    @GetMapping(value = "/testDb")
    public String testDBMethod() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        System.out.println("Inthe controller");
        String sql = "SELECT body FROM email WHERE body = ?";

        return jdbcTemplate.queryForObject(
                sql, new Object[]{"test123"}, String.class);


    }

}
