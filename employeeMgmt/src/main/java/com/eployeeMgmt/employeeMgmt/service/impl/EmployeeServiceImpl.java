package com.eployeeMgmt.employeeMgmt.service.impl;

import com.eployeeMgmt.employeeMgmt.client.DepartmentClient;
import com.eployeeMgmt.employeeMgmt.client.NotificationClient;
import com.eployeeMgmt.employeeMgmt.dto.DepartmentDetails;
import com.eployeeMgmt.employeeMgmt.dto.EmployeeDetailsResponse;
import com.eployeeMgmt.employeeMgmt.model.EmployeeDetails;
import com.eployeeMgmt.employeeMgmt.repository.IEmployeeRepository;
import com.eployeeMgmt.employeeMgmt.service.IEmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {


    @Autowired
    private IEmployeeRepository repo;

    @Autowired
    private DepartmentClient departmentClient;

    @Autowired
    private NotificationClient notificationClient;




    public ResponseEntity<?> createNewEmployee(EmployeeDetails employee) {
        try {
            DepartmentDetails departmentDetails = departmentClient.getDepartment(employee.getDepartmentId());
            if (departmentDetails != null && departmentDetails.getId() != null) {
                EmployeeDetails savedEmployee = repo.save(employee);
                Map<String, Object> combinedMap = new HashMap<>();
                combinedMap.put("employee", employee);
                combinedMap.put("department", departmentDetails);
                Map<String,Object> response= notificationClient.sendEmailNotification(combinedMap);
                //savedEmployee.setNotificationStatus(response);
                return ResponseEntity.ok(savedEmployee);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Department with ID " + employee.getDepartmentId() + " not found.");
            }

        } catch (FeignException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Department with ID " + employee.getDepartmentId() + " not found.");
        } catch (FeignException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error communicating with Department Service: " + ex.getMessage());
        }
    }


    public EmployeeDetails getById(Long id) {

        return repo.findById(id).orElseThrow();
    }

    public EmployeeDetailsResponse getEmployeeInfo(Long id) {

        EmployeeDetails employee =  repo.findById(id).orElseThrow();
        DepartmentDetails department = departmentClient.getDepartment(employee.getDepartmentId());
        EmployeeDetailsResponse response = new EmployeeDetailsResponse();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setEmail(employee.getEmail());
        response.setDepartment(department);

        return response;
    }
    public List<EmployeeDetails> getAll() {
        return repo.findAll();
    }

    public EmployeeDetails update(Long id, EmployeeDetails updated) {
        EmployeeDetails emp = getById(id);
        emp.setName(updated.getName());
        emp.setEmail(updated.getEmail());
        emp.setDepartmentId(updated.getDepartmentId());
        return repo.save(emp);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }


}
