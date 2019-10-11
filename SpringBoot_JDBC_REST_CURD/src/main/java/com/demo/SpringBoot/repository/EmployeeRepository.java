package com.demo.SpringBoot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.SpringBoot.model.Employee;

@Repository

public class EmployeeRepository {
    @Autowired
    JdbcTemplate template;
    
    public int save(Employee p){    
        String sql="insert into employee(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";    
        return template.update(sql);    
    } 
    
    public Employee findById(int id){    
        String sql="select * from Employee where id=?";    
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));    
    }  
    
    public int deleteById(int id){    
        String sql="delete from Employee where id="+id+"";    
        return template.update(sql);    
    }    
    public List<Employee> findAll(){    
        return template.query("select * from Employee",new RowMapper<Employee>(){    
            public Employee mapRow(ResultSet rs, int row) throws SQLException {    
                Employee e=new Employee();    
                e.setId(rs.getInt(1));    
                e.setName(rs.getString(2));    
                e.setSalary(rs.getInt(3));    
                e.setDesignation(rs.getString(4));    
                return e;    
            }    
        });    
    }
}
