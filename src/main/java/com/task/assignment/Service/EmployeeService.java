package com.task.assignment.Service;

import com.task.assignment.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long empId, Employee employee);
    void deleteEmployee(Long empId);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long empId);
}