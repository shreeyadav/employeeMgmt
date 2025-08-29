package com.eployeeMgmt.employeeMgmt.client;


import com.eployeeMgmt.employeeMgmt.dto.DepartmentDetails;
import com.eployeeMgmt.employeeMgmt.model.EmployeeDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(name = "notification-service")
public interface NotificationClient {
//    @PostMapping("/notifications")
//    void sendNotification(@RequestBody NotificationRequest request);

    @PostMapping(
            value = "/notifications",
            consumes = "application/json",
            produces = "application/json",
            headers = "Content-Type=application/json"
    )
    Map<String, Object> sendEmailNotification(@RequestBody Map<String, Object> json);
}
