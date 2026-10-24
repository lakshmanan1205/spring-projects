package com.lionel.employeeManagement.rest;

import com.lionel.employeeManagement.entity.Employee;
import com.lionel.employeeManagement.error.EmployeeNotFoundException;
import com.lionel.employeeManagement.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        return employeeService.getEmployee(employeeId);
    }
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody  Employee employee){
        System.out.println("From lakshmanan" + employee);
        return employeeService.saveEmployee(employee);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId){
        Employee dbEmployee = employeeService.getEmployee(employeeId);
        if(employeeId<0 || dbEmployee==null){
            throw new EmployeeNotFoundException("Employee ID Not Found");
        }
        employeeService.deleteEmployee(dbEmployee);
        return ResponseEntity.noContent().build();
    }
}
