package com.jpmc.ems.mapper;

import com.jpmc.ems.domain.Department;
import com.jpmc.ems.domain.Employee;
import com.jpmc.ems.domain.dto.DepartmentDto;
import com.jpmc.ems.domain.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EntityToDtoMapper {

    public EmployeeDto mapEmployeeToDTO(Employee employee) {
        var employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setSalary(employee.getSalary());

        if (employee.getDepartment() != null) {
            var departmentDto = mapDepartmentToDto(employee.getDepartment());
            employeeDto.setDepartment(departmentDto);
        }

        return employeeDto;
    }

    public DepartmentDto mapDepartmentToDto(Department department) {
        var departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        return departmentDto;
    }
}