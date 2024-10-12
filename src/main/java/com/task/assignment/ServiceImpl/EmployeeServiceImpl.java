package com.task.assignment.ServiceImpl;

import com.task.assignment.Entity.Employee;
import com.task.assignment.Repository.EmployeeRepository;
import com.task.assignment.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setName(employeeDetails.getName());
            employee.setAge(employeeDetails.getAge());
            employee.setEmail(employeeDetails.getEmail());
            employee.setPhoneNumber(employeeDetails.getPhoneNumber());
            employee.setDateOfBirth(employeeDetails.getDateOfBirth());
            employee.setQualification(employeeDetails.getQualification());
            employee.setPosition(employeeDetails.getPosition());

            return employeeRepository.save(employee);
        }
        throw new RuntimeException("Employee not found with id: " + empId);
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));
    }
}