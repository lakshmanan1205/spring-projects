package com.lionel.employeeManagement.dao;

import com.lionel.employeeManagement.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);
    public Employee saveEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
}
