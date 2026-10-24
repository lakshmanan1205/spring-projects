package com.lionel.employeeManagement.rest;

import com.lionel.employeeManagement.entity.Employee;
import com.lionel.employeeManagement.error.EmployeeValidationException;
import com.lionel.employeeManagement.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.jsonMapper = new JsonMapper();
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
    @PatchMapping("employees/{employeeID}")
    public Employee patchUpdateEmployee(@PathVariable int employeeID,@RequestBody Map<String,Object> patchPayload){
        // VALIDATIONS
        if(patchPayload.containsKey("id")){
            throw new EmployeeValidationException("Id should not present in employee Object");
        }
        Employee tempEmployee = employeeService.getEmployee(employeeID);
        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee,patchPayload);
        return employeeService.updateEmployee(patchedEmployee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId){
        Employee dbEmployee = employeeService.getEmployee(employeeId);
        employeeService.deleteEmployee(dbEmployee);
        return ResponseEntity.noContent().build();
    }
}
