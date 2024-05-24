package com.jpmc.ems.controller;

import com.jpmc.ems.domain.dto.EmployeeDto;
import com.jpmc.ems.mapper.EntityToDtoMapper;
import com.jpmc.ems.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EntityToDtoMapper entityToDtoMapper;

    public EmployeeController(EmployeeService employeeService, EntityToDtoMapper entityToDtoMapper) {
        this.employeeService = employeeService;
        this.entityToDtoMapper = entityToDtoMapper;
    }

    @GetMapping("/department/{departmentName}")
    public List<EmployeeDto> getEmployeesByDepartment(@PathVariable String departmentName) {
        return employeeService.getEmployeesByDepartment(departmentName);
    }

    @GetMapping("/salary/{salary}")
    public List<EmployeeDto> getEmployeesBySalaryGreaterThan(@PathVariable double salary) {
        return employeeService.getEmployeesBySalaryGreaterThan(salary);
    }

   /* @GetMapping("/all")
    public List<Employee> getAllEmployeesWithDepartments() {
        return employeeService.getAllEmployeesWithDepartments();
    }*/

    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployees() {
        return  employeeService.getAllEmployeesWithDepartments();
    }
}
