package com.jpmc.ems.service;

import com.jpmc.ems.domain.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    List<EmployeeDto> getEmployeesByDepartment(String departmentName);

    List<EmployeeDto> getEmployeesBySalaryGreaterThanOrEqual(double salary);

    List<EmployeeDto> getEmployeesBySalaryLessThan(double salary);

    List<EmployeeDto> getEmployeesByDepartmentAndSalaryGreaterThanOrEqual(String departmentName, double salary);

    List<EmployeeDto> getEmployeesByDepartmentAndSalaryLessThan(String departmentName, double salary);
}
