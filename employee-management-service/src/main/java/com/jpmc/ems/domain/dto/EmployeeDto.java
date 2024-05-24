package com.jpmc.ems.domain.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {
    private Long id;
    private String name;
    private DepartmentDto department;
    private double salary;
}