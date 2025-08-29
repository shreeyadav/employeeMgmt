package com.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendDepartmentAssignmentEmail(String toEmail, String employeeName, String departmentName) {
        String subject = "Department Assignment Reminder";
        String body = String.format("%s, you are assigned to the %s department",employeeName,departmentName);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("your_email@gmail.com");

        mailSender.send(message);

    }
}
