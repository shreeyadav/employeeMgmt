package com.eployeeMgmt.employeeMgmt.service;

import com.eployeeMgmt.employeeMgmt.dto.EmployeeDetailsResponse;
import com.eployeeMgmt.employeeMgmt.model.EmployeeDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {

    ResponseEntity<?> createNewEmployee(EmployeeDetails emp);

    EmployeeDetails getById(Long id);
    void delete(Long id);

    EmployeeDetails update(Long id, EmployeeDetails emp);

    List<EmployeeDetails> getAll();

    EmployeeDetailsResponse getEmployeeInfo(Long id);

    Page<EmployeeDetails> getAllEmployees(Pageable pageRequest);
}
