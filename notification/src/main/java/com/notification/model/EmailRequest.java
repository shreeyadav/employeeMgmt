package com.notification.model;

public class EmailRequest {


    private String email;
    private String employeeName;
    private String departmentName;
    public EmailRequest() {
    }
    public EmailRequest(String email, String employeeName, String departmentName) {
        this.email = email;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }



}
