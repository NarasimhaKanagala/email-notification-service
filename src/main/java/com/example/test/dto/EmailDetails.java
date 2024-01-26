package com.example.test.dto;

public class EmailDetails {

    private Integer id;
    private String body;
    private String status;
    private String toEmail;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }



    public EmailDetails(Integer id, String body, String status, String toEmail) {
        this.id = id;
        this.body = body;
        this.status = status;
        this.toEmail = toEmail;
    }
}
