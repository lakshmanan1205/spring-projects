package com.lionel.employeeManagement.service;

import com.lionel.employeeManagement.entity.Employee;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);
    public Employee saveEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
}
