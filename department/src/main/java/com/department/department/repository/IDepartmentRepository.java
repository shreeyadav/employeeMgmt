package com.department.department.repository;

import com.department.department.model.DepartmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends JpaRepository<DepartmentDetails, Long> {
}
