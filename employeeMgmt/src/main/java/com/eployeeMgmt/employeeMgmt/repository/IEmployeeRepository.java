package com.eployeeMgmt.employeeMgmt.repository;

import com.eployeeMgmt.employeeMgmt.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeDetails, Long> {
}
