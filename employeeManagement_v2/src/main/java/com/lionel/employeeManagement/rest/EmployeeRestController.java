package com.lionel.employeeManagement.rest;

import com.lionel.employeeManagement.entity.Employee;
import com.lionel.employeeManagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/{employeeID}")
    public Employee findByID(@PathVariable int employeeID){
        return employeeService.findByID(employeeID);
    }
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }
    @PatchMapping("/{employeeID}")
    public Employee partialUpdate(@PathVariable int employeeID, @RequestBody Map<String,Object> patchPayload){
        return employeeService.updatePartial(employeeID,patchPayload);
    }
    @DeleteMapping("/{employeeID}")
    public void deleteByID(@PathVariable int employeeID){
        employeeService.deleteByID(employeeID);
    }
}
