package com.jpmc.ems.controller;

import com.jpmc.ems.domain.dto.EmployeeDto;
import com.jpmc.ems.mapper.EntityToDtoMapper;
import com.jpmc.ems.service.EmployeeService;
import com.jpmc.ems.service.EmployeeServiceImpl;
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

    public EmployeeController(EmployeeServiceImpl employeeService, EntityToDtoMapper entityToDtoMapper) {
        this.employeeService = employeeService;
        this.entityToDtoMapper = entityToDtoMapper;
    }

    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/department/{departmentName}")
    public List<EmployeeDto> getEmployeesByDepartment(@PathVariable String departmentName) {
        return employeeService.getEmployeesByDepartment(departmentName);
    }

    @GetMapping("/salaryGreaterThanOrEqual/{salary}")
    public List<EmployeeDto> getEmployeesBySalaryGreaterThanOrEqual(@PathVariable double salary) {
        return employeeService.getEmployeesBySalaryGreaterThanOrEqual(salary);
    }

    @GetMapping("/salaryLessThan/{salary}")
    public List<EmployeeDto> getEmployeesBySalaryLessThan(@PathVariable double salary) {
        return employeeService.getEmployeesBySalaryLessThan(salary);
    }

    @GetMapping("/department/{departmentName}/salaryGreaterThanOrEqual/{salary}")
    public List<EmployeeDto> getEmployeesByDepartmentAndSalaryGreaterThanOrEqual(
            @PathVariable String departmentName,
            @PathVariable double salary) {
        return employeeService.getEmployeesByDepartmentAndSalaryGreaterThanOrEqual(departmentName, salary);
    }

    @GetMapping("/department/{departmentName}/salaryLessThan/{salary}")
    public List<EmployeeDto> getEmployeesByDepartmentAndSalaryLessThan(
            @PathVariable String departmentName,
            @PathVariable double salary) {
        return employeeService.getEmployeesByDepartmentAndSalaryLessThan(departmentName, salary);
    }

}
