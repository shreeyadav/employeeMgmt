package com.notification.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.dto.DepartmentDetails;
import com.notification.dto.EmployeeDetails;
import com.notification.model.EmailRequest;
import com.notification.model.NotificationRequest;
import com.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping
    public ResponseEntity<?> sendEmailNotification(@RequestBody Map<String, Object> employeeJson) {
        ObjectMapper mapper = new ObjectMapper();

        // Convert nested maps to POJOs
        EmployeeDetails employee = mapper.convertValue(employeeJson.get("employee"), EmployeeDetails.class);
        DepartmentDetails department = mapper.convertValue(employeeJson.get("department"), DepartmentDetails.class);

        String employeeName = employee.getName();
        String departmentName = department.getName();

        String subject = "Department Assignment Reminder";
        String body = String.format("%s, you are assigned to the %s department.", employeeName, departmentName);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("shridharyadav32@gmail.com"); // assuming EmployeeDetails has getEmail()
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("shridharyadav256@gmail.com");

        mailSender.send(message);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Mail sent successfully");

        return ResponseEntity.ok(response);
    }

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        emailService.sendDepartmentAssignmentEmail(
                request.getEmail(),
                request.getEmployeeName(),
                request.getDepartmentName()
        );
        return ResponseEntity.ok("Email sent successfully");
    }
}
