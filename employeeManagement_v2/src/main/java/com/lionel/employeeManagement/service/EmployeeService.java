package com.lionel.employeeManagement.service;

import com.lionel.employeeManagement.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findByID(int id);
    public Employee save(Employee employee);
    public Employee update(Employee employee);
    public Employee updatePartial(int id, Map<String,Object> patchPayload);
    public void deleteByID(int id);
}
