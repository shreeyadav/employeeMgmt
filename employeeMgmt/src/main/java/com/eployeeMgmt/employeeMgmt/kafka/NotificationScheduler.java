package com.eployeeMgmt.employeeMgmt.kafka;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationScheduler {
    @Scheduled(fixedRate = 60000)
    public void sendReminder() {
        System.out.println("Reminder: Check your department updates!");
    }
}
