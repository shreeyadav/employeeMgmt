package com.department.department.service;

import com.department.department.model.DepartmentDetails;

import java.util.List;

public interface IDepartmentService {


    DepartmentDetails createDepartment(DepartmentDetails dept);

    List<DepartmentDetails> getAll();

    DepartmentDetails getDepartment(Long id);
    DepartmentDetails update(Long id, DepartmentDetails dept);

    void delete(Long id);
}
