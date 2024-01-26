package com.example.test.utils;

import com.example.test.dto.EmailDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmailDetails> {
    @Override
    public EmailDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EmailDetails(
                rs.getInt("id"),
                rs.getString("body"),
                rs.getString("status"),
                rs.getString("toEmail")


        );
    }
}
