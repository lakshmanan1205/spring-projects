package com.lionel.employeeManagement.dao;

import com.lionel.employeeManagement.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    private EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery theQuery = entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee> resultSet =theQuery.getResultList();
        return resultSet;
    }

    @Override
    public Employee getEmployee(int id) {
        Employee dbEmployee = entityManager.find(Employee.class,id);
        return dbEmployee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteEmployee(Employee employee) {
         entityManager.remove(employee);
    }
}
