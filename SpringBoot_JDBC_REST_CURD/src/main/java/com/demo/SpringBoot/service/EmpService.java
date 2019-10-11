package com.demo.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBoot.model.Employee;
import com.demo.SpringBoot.repository.EmployeeRepository;




@Service
public class EmpService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void save(Employee emp) {
		employeeRepository.save(emp);
	}
	
	public Employee findById(int id){
		return employeeRepository.findById(id);
	}
	
	public List<Employee>findAll(){
		return employeeRepository.findAll();
	}
	
	public void update(Employee emp) {
		employeeRepository.save(emp);
	}
	
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
