package com.demo.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBoot.model.Employee;
import com.demo.SpringBoot.service.EmpService;


@RestController
public class EmpController {
	
	@Autowired
	EmpService EmployeeService;
	
	@PostMapping(value="/save")  
	public void addemployee(@RequestBody Employee emp) {
		EmployeeService.save(emp);
	}
	
	@GetMapping(value = "employee/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		return EmployeeService.findById(id); 
	}
	
    @GetMapping(value = "employees")
    public List<Employee> getAllEmployee(){
        return EmployeeService.findAll();
    }
    @PutMapping(value="/employee")
    public void employeeUpdate(@RequestBody Employee emp){
    	
    	EmployeeService.update(emp);
 
    }
    @DeleteMapping(value="/employee/{id}")
    public void studentDelete(@PathVariable Integer id) {
    	EmployeeService.deleteById(id);
    }
}
