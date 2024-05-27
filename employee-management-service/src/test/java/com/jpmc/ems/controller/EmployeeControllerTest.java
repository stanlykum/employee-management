package com.jpmc.ems.controller;

import com.jpmc.ems.domain.dto.DepartmentDto;
import com.jpmc.ems.domain.dto.EmployeeDto;
import com.jpmc.ems.mapper.EntityToDtoMapper;
import com.jpmc.ems.service.EmployeeServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServiceImpl employeeService;

    @MockBean
    private EntityToDtoMapper entityToDtoMapper;

    @Test
    @DisplayName("Should get all employees")
    void shouldGetAllEmployees() throws Exception {

        // given
        var itDepartment = new DepartmentDto(1L, "IT");
        var financeDepartment = new DepartmentDto(2L, "Finance");

        List<EmployeeDto> expectedEmployees = Arrays.asList(
                EmployeeDto.builder().id(1L).name("John").department(itDepartment).salary(50000.0).build(),
                EmployeeDto.builder().id(2L).name("Jane").department(financeDepartment).salary(60000.0).build()
        );
        when(employeeService.getAllEmployees()).thenReturn(expectedEmployees);

        // when / then
        mockMvc.perform(get("/api/employees/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].department.name").value("IT"))
                .andExpect(jsonPath("$[0].salary").value(50000.0));
    }

    @Test
    @DisplayName("Should get employees by department")
    void shouldGetEmployeesByDepartment() throws Exception {
        // given
        var departmentName = "IT";
        var itDepartment = new DepartmentDto(1L, "IT");

        var expectedEmployees = Arrays.asList(
                EmployeeDto.builder().id(1L).name("John").department(itDepartment).salary(50000.0).build()
        );
        when(employeeService.getEmployeesByDepartment(departmentName)).thenReturn(expectedEmployees);

        // when / then
        mockMvc.perform(get("/api/employees/department/{departmentName}", departmentName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].department.name").value("IT"))
                .andExpect(jsonPath("$[0].salary").value(50000.0));
    }

    @Test
    @DisplayName("Should get employees greater than or equal to salary")
    void shouldGetEmployeesBySalaryGreaterThanOrEqual() throws Exception {
        // given
        double salary = 50000.0;
        var itDepartment = new DepartmentDto(1L, "IT");
        var financeDepartment = new DepartmentDto(2L, "Finance");

        var expectedEmployees = Arrays.asList(
                EmployeeDto.builder().id(1L).name("John").department(itDepartment).salary(60000.0).build(),
                EmployeeDto.builder().id(2L).name("Jane").department(financeDepartment).salary(70000.0).build()
        );
        when(employeeService.getEmployeesBySalaryGreaterThanOrEqual(salary)).thenReturn(expectedEmployees);

        // when / then
        mockMvc.perform(get("/api/employees/salaryGreaterThanOrEqual/{salary}", salary))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].department.name").value("IT"))
                .andExpect(jsonPath("$[0].salary").value(60000.0));
    }

    @Test
    @DisplayName("Should get employees less than salary")
    void shouldGetEmployeesBySalaryLessThan() throws Exception {
        // given
        double salary = 50000.0;
        var itDepartment = new DepartmentDto(1L, "IT");
        var financeDepartment = new DepartmentDto(2L, "Finance");

        var expectedEmployees = Arrays.asList(
                EmployeeDto.builder().id(1L).name("John").department(itDepartment).salary(40000.0).build(),
                EmployeeDto.builder().id(2L).name("Jane").department(financeDepartment).salary(30000.0).build()
        );
        when(employeeService.getEmployeesBySalaryLessThan(salary)).thenReturn(expectedEmployees);

        // when / then
        mockMvc.perform(get("/api/employees/salaryLessThan/{salary}", salary))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].department.name").value("IT"))
                .andExpect(jsonPath("$[0].salary").value(40000.0));
    }

    @Test
    @DisplayName("Should get employees greater than or equal by department and salary")
    void shouldGetEmployeesByDepartmentAndSalaryGreaterThanOrEqual() throws Exception {
        // given
        var departmentName = "IT";
        double salary = 50000.0;
        var itDepartment = new DepartmentDto(1L, "IT");

        List<EmployeeDto> expectedEmployees = Arrays.asList(
                EmployeeDto.builder().id(1L).name("John").department(itDepartment).salary(60000.0).build()
        );
        when(employeeService.getEmployeesByDepartmentAndSalaryGreaterThanOrEqual(departmentName, salary)).thenReturn(expectedEmployees);

        // when / then
        mockMvc.perform(get("/api/employees/department/{departmentName}/salaryGreaterThanOrEqual/{salary}", departmentName, salary))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].department.name").value("IT"))
                .andExpect(jsonPath("$[0].salary").value(60000.0));
    }

    @Test
    @DisplayName("Should get employees less than or equal by department and salary")
    void testGetEmployeesByDepartmentAndSalaryLessThan() throws Exception {
        // given
        var departmentName = "IT";
        double salary = 50000.0;
        DepartmentDto itDepartment = new DepartmentDto(1L, "IT");

        var expectedEmployees = Arrays.asList(
                EmployeeDto.builder().id(1L).name("John").department(itDepartment).salary(40000.0).build()
        );
        when(employeeService.getEmployeesByDepartmentAndSalaryLessThan(departmentName, salary)).thenReturn(expectedEmployees);

        // when / then
        mockMvc.perform(get("/api/employees/department/{departmentName}/salaryLessThan/{salary}", departmentName, salary))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].department.name").value("IT"))
                .andExpect(jsonPath("$[0].salary").value(40000.0));
    }
}