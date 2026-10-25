package com.lionel.employeeManagement.service;

import com.lionel.employeeManagement.dao.EmployeeRepository;
import com.lionel.employeeManagement.entity.Employee;
import com.lionel.employeeManagement.error.EmployeeNotFoundException;
import com.lionel.employeeManagement.error.EmployeeValidationException;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private JsonMapper jsonMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, JsonMapper jsonMapper) {
        this.employeeRepository = employeeRepository;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByID(int id) {
        if(id <0){
            throw new EmployeeValidationException("Enter Valid ID");
        }
        Optional<Employee> dbEmployee = employeeRepository.findById(id);
        if(dbEmployee.isEmpty()){
            throw new EmployeeNotFoundException();
        }
        return dbEmployee.get();
    }

    @Override
    public Employee save(Employee employee) {
        // FOR SAFETY WE SET NULL TO CREATE A VALUE EVEN OBJECT HOLDS ID IN PAYLOAD
        employee.setId(null);
        employeeValidations(employee);
        Employee dbEmployee = employeeRepository.save(employee);
        return dbEmployee;
    }

    @Override
    public Employee update(Employee employee) {
        employeeValidations(employee);
        Employee dbEmployee = employeeRepository.save(employee);
        return dbEmployee;
    }

    @Override
    public Employee updatePartial(int id, Map<String, Object> patchPayload) {
        if(id<0){
            throw new EmployeeValidationException("Enter Valid Id");
        }
        Optional<Employee> dbEmployee = employeeRepository.findById(id);
        if(dbEmployee.isEmpty()){
            throw new EmployeeNotFoundException();
        }
        Employee patchedEmployee = jsonMapper.updateValue(dbEmployee.get(),patchPayload);
        employeeValidations(patchedEmployee);
        return patchedEmployee;
    }

    @Override
    public void deleteByID(int id) {
        if(id <0){
            throw new EmployeeValidationException("Enter Valid ID");
        }
        Optional<Employee> dbEmployee = employeeRepository.findById(id);
        if(dbEmployee.isEmpty()){
            throw new EmployeeNotFoundException();
        }
        employeeRepository.deleteById(id);
    }

    public void employeeValidations(Employee employee){
        if(employee.getSalary()<0){
            throw new EmployeeValidationException("Enter valid Salary");
        }else if(employee.getEmail()==null){
            throw new EmployeeValidationException("Enter Valid Email");
        }else if(employee.getFirstName()==null){
            throw new EmployeeValidationException("Enter Valid First Name");
        }else if(employee.getLastName()==null){
            throw new EmployeeValidationException("Enter Valid Last Name");
        }else if(employee.getDepartment()==null){
            throw new EmployeeValidationException("Enter Valid Department");
        }
    }
}
