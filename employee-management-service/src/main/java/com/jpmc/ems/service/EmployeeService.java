package com.jpmc.ems.service;

import com.jpmc.ems.domain.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    List<EmployeeDto> getEmployeesByDepartment(String departmentName);

    List<EmployeeDto> getEmployeesBySalaryGreaterThanOrEqual(double minSalary);

    List<EmployeeDto> getEmployeesBySalaryLessThan(double maxSalary);

    List<EmployeeDto> getEmployeesByDepartmentAndSalaryGreaterThanOrEqual(String departmentName, double minSalary);

    List<EmployeeDto> getEmployeesByDepartmentAndSalaryLessThan(String departmentName, double maxSalary);
}
