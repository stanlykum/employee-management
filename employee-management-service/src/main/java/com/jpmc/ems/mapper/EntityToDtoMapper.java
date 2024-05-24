package com.jpmc.ems.mapper;

import com.jpmc.ems.domain.Department;
import com.jpmc.ems.domain.Employee;
import com.jpmc.ems.domain.dto.DepartmentDto;
import com.jpmc.ems.domain.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EntityToDtoMapper {

    public EmployeeDto mapEmployeeToDTO(Employee employee) {
        EmployeeDto employeeDTO = new EmployeeDto();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());

        if (employee.getDepartment() != null) {
            DepartmentDto departmentDTO = mapDepartmentToDto(employee.getDepartment());
            employeeDTO.setDepartment(departmentDTO);
        }

        return employeeDTO;
    }

    public DepartmentDto mapDepartmentToDto(Department department) {
        DepartmentDto departmentDTO = new DepartmentDto();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        return departmentDTO;
    }
}