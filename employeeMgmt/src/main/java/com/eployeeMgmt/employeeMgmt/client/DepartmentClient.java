package com.eployeeMgmt.employeeMgmt.client;

import com.eployeeMgmt.employeeMgmt.dto.DepartmentDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface DepartmentClient {
    @GetMapping("/departments/getDepartment/{id}")
    DepartmentDetails getDepartment(@PathVariable("id") Long id);
}

