package com.jpmc.ems.service;

import com.jpmc.ems.domain.dto.EmployeeDto;
import com.jpmc.ems.mapper.EntityToDtoMapper;
import com.jpmc.ems.repository.DepartmentRepository;
import com.jpmc.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EntityToDtoMapper entityToDtoMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EntityToDtoMapper entityToDtoMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.entityToDtoMapper = entityToDtoMapper;
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        var employees = employeeRepository.findAll();
        return employees.stream()
                .map(entityToDtoMapper::mapEmployeeToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartment(String departmentName) {
        var department = departmentRepository.findByName(departmentName);
        var employees = employeeRepository.findByDepartment(department);
        return employees.stream()
                .map(entityToDtoMapper::mapEmployeeToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesBySalaryGreaterThanOrEqual(double salary) {
        var employees = employeeRepository.findBySalaryGreaterThanOrEqual(salary);
        return employees.stream()
                .map(entityToDtoMapper::mapEmployeeToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesBySalaryLessThan(double salary) {
        var employees = employeeRepository.findBySalaryLessThan(salary);
        return employees.stream()
                .map(entityToDtoMapper::mapEmployeeToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartmentAndSalaryGreaterThanOrEqual(String departmentName, double salary) {
        var employees = employeeRepository.findByDepartmentAndSalaryGreaterThanOrEqual(departmentName, salary);
        return employees.stream()
                .map(entityToDtoMapper::mapEmployeeToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartmentAndSalaryLessThan(String departmentName, double maxSalary) {
        var employees = employeeRepository.findByDepartmentAndSalaryLessThan(departmentName, maxSalary);
        return employees.stream()
                .map(entityToDtoMapper::mapEmployeeToDTO)
                .collect(Collectors.toList());
    }
}
