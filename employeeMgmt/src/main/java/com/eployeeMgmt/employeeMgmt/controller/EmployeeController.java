package com.eployeeMgmt.employeeMgmt.controller;

import com.eployeeMgmt.employeeMgmt.dto.EmployeeDetailsResponse;
import com.eployeeMgmt.employeeMgmt.model.EmployeeDetails;
import com.eployeeMgmt.employeeMgmt.client.NotificationClient;
import com.eployeeMgmt.employeeMgmt.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService service;

    @Autowired
    private NotificationClient notificationClient;

    @PostMapping("/createNewEmployee")
    public ResponseEntity<?> createNewEmployee(@RequestBody EmployeeDetails emp) {
        return service.createNewEmployee(emp);
    }

    @GetMapping("getEmployeeById/{id}")
    public EmployeeDetails getEmployeeById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("getAllEmployee")
    public List<EmployeeDetails> getAll() {
        return service.getAll();
    }

    @GetMapping("getEmployeeInfo/{id}")
    public EmployeeDetailsResponse getEmployeeInfo(@PathVariable Long id){
        return service.getEmployeeInfo(id);
    }

    @PutMapping("updateEmployee/{id}")
    public EmployeeDetails updateEmployee(@PathVariable Long id, @RequestBody EmployeeDetails emp) {
        return service.update(id, emp);
    }

    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }


}
