package com.jpmc.ems.controller;

import com.jpmc.ems.domain.dto.EmployeeDto;
import com.jpmc.ems.mapper.EntityToDtoMapper;
import com.jpmc.ems.service.EmployeeService;
import com.jpmc.ems.service.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Get all employees", description = "Get all employees")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = List.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/department/{departmentName}")
    @Operation(summary = "Get employees by department", description = "Get employees by department")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = List.class)))
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public List<EmployeeDto> getEmployeesByDepartment(@PathVariable String departmentName) {
        return employeeService.getEmployeesByDepartment(departmentName);
    }

    @GetMapping("/salaryGreaterThanOrEqual/{salary}")
    @Operation(summary = "Get Salary greater than or equal to salary", description = "Get Salary greater than or equal to salary")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = List.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public List<EmployeeDto> getEmployeesBySalaryGreaterThanOrEqual(@PathVariable double salary) {
        return employeeService.getEmployeesBySalaryGreaterThanOrEqual(salary);
    }

    @GetMapping("/salaryLessThan/{salary}")
    @Operation(summary = "Get Salary less than salary", description = "Get Salary less than salary")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = List.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public List<EmployeeDto> getEmployeesBySalaryLessThan(@PathVariable double salary) {
        return employeeService.getEmployeesBySalaryLessThan(salary);
    }

    @GetMapping("/department/{departmentName}/salaryGreaterThanOrEqual/{salary}")
    @Operation(summary = "Get Salary greater than or equal by department and salary", description = "Get Salary greater than or equal by department and salary")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = List.class)))
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public List<EmployeeDto> getEmployeesByDepartmentAndSalaryGreaterThanOrEqual(
            @PathVariable String departmentName,
            @PathVariable double salary) {
        return employeeService.getEmployeesByDepartmentAndSalaryGreaterThanOrEqual(departmentName, salary);
    }

    @GetMapping("/department/{departmentName}/salaryLessThan/{salary}")
    @Operation(summary = "Get Salary less than by department and salary", description = "Get Salary less than by department and salary")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = List.class)))
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public List<EmployeeDto> getEmployeesByDepartmentAndSalaryLessThan(
            @PathVariable String departmentName,
            @PathVariable double salary) {
        return employeeService.getEmployeesByDepartmentAndSalaryLessThan(departmentName, salary);
    }

}
