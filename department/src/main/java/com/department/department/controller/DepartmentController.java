package com.department.department.controller;

import com.department.department.model.DepartmentDetails;
import com.department.department.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

//    @Autowired
    private IDepartmentService departmentService;
    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }
//    @Autowired
//    private KafkaProducer producer;

    @PostMapping
    public DepartmentDetails createDepartment(@RequestBody DepartmentDetails dept) {
         return departmentService.createDepartment(dept);
      //  producer.sendEvent("Department created: " + saved.getName());

    }

    @GetMapping("/getDepartment/{id}")
    public DepartmentDetails getDepartment(@PathVariable("id") Long id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping
    public List<DepartmentDetails> getAll() {
        return departmentService.getAll();
    }

    @PutMapping("/{id}")
    public DepartmentDetails update(@PathVariable Long id, @RequestBody DepartmentDetails dept) {
        return departmentService.update(id, dept);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        departmentService.delete(id);
       // producer.sendEvent("Department deleted: " + id);
    }
}
