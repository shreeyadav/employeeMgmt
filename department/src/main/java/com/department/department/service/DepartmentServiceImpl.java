package com.department.department.service;

import com.department.department.model.DepartmentDetails;
import com.department.department.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;

    public DepartmentDetails createDepartment(DepartmentDetails dept) {
        return departmentRepository.save(dept);
    }

    public DepartmentDetails getDepartment(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found with ID: " + id));

    }

    public List<DepartmentDetails> getAll() {
        return departmentRepository.findAll();
    }

    public DepartmentDetails update(Long id, DepartmentDetails updated) {
        DepartmentDetails dept = getDepartment(id);
        dept.setName(updated.getName());
        dept.setLocation(updated.getLocation());
        return departmentRepository.save(dept);
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
