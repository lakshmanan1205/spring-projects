package com.lionel.employeeManagement.service;

import com.lionel.employeeManagement.dao.EmployeeDao;
import com.lionel.employeeManagement.entity.Employee;
import com.lionel.employeeManagement.error.EmployeeNotFoundException;
import com.lionel.employeeManagement.error.EmployeeValidationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        if(id<0){
            throw new EmployeeNotFoundException("Employee Not found");
        }
        Employee dbEmployee = employeeDao.getEmployee(id);
        if(dbEmployee == null){
            throw new EmployeeNotFoundException("Employee Not found");
        }
        return dbEmployee;
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        // FOR SAFETY MANUALLY SET ID AS 0
        employee.setId(null);
        // VALIDATIONS
        isValidEmployeeObject(employee);
        System.out.println("Lakshmanan department "+employee.getDepartment());
        Employee dbEmployee =  employeeDao.saveEmployee(employee);
        return dbEmployee;
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        // VALIDATIONS
        if(employee.getId()==null || employee.getId()<0 ){
            throw new EmployeeValidationException("Enter Valid Id");
        }
        isValidEmployeeObject(employee);
        return employeeDao.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }

    // VALIDATIONS
    public void isValidEmployeeObject(Employee employee){
        if(employee.getDepartment() == null){
            throw new EmployeeValidationException("Department is required");
        }else if(employee.getFirstName() == null){
            throw new EmployeeValidationException("First Name is required");
        }else if(employee.getLastName() == null){
            throw new EmployeeValidationException("Last Name is required");
        }else if(employee.getEmail() == null){
            throw new EmployeeValidationException("Email is required");
        }else if(employee.getSalary() <0) {
            throw new EmployeeValidationException("Enter valid Salary");
        }
    }
}
