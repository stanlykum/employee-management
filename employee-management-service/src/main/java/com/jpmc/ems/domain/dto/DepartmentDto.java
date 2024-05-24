package com.jpmc.ems.domain.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDto {
    private Long id;
    private String name;
}