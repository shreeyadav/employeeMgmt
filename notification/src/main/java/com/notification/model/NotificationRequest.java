package com.notification.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
