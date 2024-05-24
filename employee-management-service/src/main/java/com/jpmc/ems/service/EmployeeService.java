package com.jpmc.ems.service;

import com.jpmc.ems.domain.Department;
import com.jpmc.ems.domain.Employee;
import com.jpmc.ems.domain.dto.EmployeeDto;
import com.jpmc.ems.mapper.EntityToDtoMapper;
import com.jpmc.ems.repository.DepartmentRepository;
import com.jpmc.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EntityToDtoMapper entityToDtoMapper;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EntityToDtoMapper entityToDtoMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.entityToDtoMapper = entityToDtoMapper;
    }

    public List<EmployeeDto> getEmployeesByDepartment(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        List<Employee> employees = employeeRepository.findByDepartment(department);
        return employees.stream()
                .map(entityToDtoMapper::mapEmployeeToDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> getEmployeesBySalaryGreaterThan(double salary) {
        List<Employee> employees = employeeRepository.findBySalaryGreaterThan(salary);
        return employees.stream()
                .map(entityToDtoMapper::mapEmployeeToDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> getAllEmployeesWithDepartments() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(entityToDtoMapper::mapEmployeeToDTO)
                .collect(Collectors.toList());
    }

}
