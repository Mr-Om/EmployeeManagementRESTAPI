package com.api.employee.dao;

import com.api.employee.Entity.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
