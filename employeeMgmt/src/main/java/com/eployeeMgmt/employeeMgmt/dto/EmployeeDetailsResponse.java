package com.eployeeMgmt.employeeMgmt.dto;

import com.eployeeMgmt.employeeMgmt.model.EmployeeDetails;
import lombok.*;

@Data
@Getter
@Setter
public class EmployeeDetailsResponse {
    private Long id;
    private String name;
    private String email;
    private DepartmentDetails department;
    public EmployeeDetailsResponse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DepartmentDetails getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDetails department) {
        this.department = department;
    }

    public EmployeeDetailsResponse(String name, String email, DepartmentDetails departmentName) {
        this.name = name;
        this.email = email;
        this.department = departmentName;
    }

}
