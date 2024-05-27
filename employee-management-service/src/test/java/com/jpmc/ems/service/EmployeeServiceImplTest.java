package com.jpmc.ems.service;

import com.jpmc.ems.domain.Department;
import com.jpmc.ems.domain.Employee;
import com.jpmc.ems.domain.dto.DepartmentDto;
import com.jpmc.ems.domain.dto.EmployeeDto;
import com.jpmc.ems.mapper.EntityToDtoMapper;
import com.jpmc.ems.repository.DepartmentRepository;
import com.jpmc.ems.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private EntityToDtoMapper entityToDtoMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Department itDepartment;
    private Department financeDepartment;
    private Employee johnDoe;
    private Employee janeSmith;

    @BeforeEach
    void setUp() {
        itDepartment = new Department();
        itDepartment.setId(1L);
        itDepartment.setName("IT");

        financeDepartment = new Department();
        financeDepartment.setId(2L);
        financeDepartment.setName("Finance");

        johnDoe = new Employee(1L, "John", itDepartment, 50000.0);
        janeSmith = new Employee(2L, "Jane", financeDepartment, 60000.0);
    }

    @Test
    @DisplayName("Should get all employees")
    void shouldGetAllEmployees() {
        // given
        List<Employee> employees = Arrays.asList(johnDoe, janeSmith);
        List<EmployeeDto> expectedEmployeeDtos = Arrays.asList(
                new EmployeeDto(1L, "John", new DepartmentDto(1L, "IT"), 50000.0),
                new EmployeeDto(2L, "Jane", new DepartmentDto(2L, "Finance"), 60000.0)
        );

        when(employeeRepository.findAll()).thenReturn(employees);
        when(entityToDtoMapper.mapEmployeeToDTO(johnDoe)).thenReturn(expectedEmployeeDtos.get(0));
        when(entityToDtoMapper.mapEmployeeToDTO(janeSmith)).thenReturn(expectedEmployeeDtos.get(1));

        // when
        List<EmployeeDto> actualEmployeeDtos = employeeService.getAllEmployees();

        // then
        assertThat(actualEmployeeDtos).isEqualTo(expectedEmployeeDtos);
    }

    @Test
    @DisplayName("Should get employees by department")
    void shouldGetEmployeesByDepartment() {
        // given
        String departmentName = "IT";
        List<Employee> employees = Arrays.asList(johnDoe);
        List<EmployeeDto> expectedEmployeeDtos = Arrays.asList(
                new EmployeeDto(1L, "John", new DepartmentDto(1L, "IT"), 50000.0)
        );

        when(departmentRepository.findByName(departmentName)).thenReturn(itDepartment);
        when(employeeRepository.findByDepartment(itDepartment)).thenReturn(employees);
        when(entityToDtoMapper.mapEmployeeToDTO(johnDoe)).thenReturn(expectedEmployeeDtos.get(0));

        // when
        List<EmployeeDto> actualEmployeeDtos = employeeService.getEmployeesByDepartment(departmentName);

        // then
        assertThat(actualEmployeeDtos).isEqualTo(expectedEmployeeDtos);
    }

    @Test
    @DisplayName("Should get employees greater than or equal to salary")
    void shouldGetEmployeesBySalaryGreaterThanOrEqual() {
        // given
        double salary = 50000.0;
        List<Employee> employees = Arrays.asList(johnDoe, janeSmith);
        List<EmployeeDto> expectedEmployeeDtos = Arrays.asList(
                new EmployeeDto(1L, "John", new DepartmentDto(1L, "IT"), 50000.0),
                new EmployeeDto(2L, "Jane", new DepartmentDto(2L, "Finance"), 60000.0)
        );

        when(employeeRepository.findBySalaryGreaterThanOrEqual(salary)).thenReturn(employees);
        when(entityToDtoMapper.mapEmployeeToDTO(johnDoe)).thenReturn(expectedEmployeeDtos.get(0));
        when(entityToDtoMapper.mapEmployeeToDTO(janeSmith)).thenReturn(expectedEmployeeDtos.get(1));

        // when
        List<EmployeeDto> actualEmployeeDtos = employeeService.getEmployeesBySalaryGreaterThanOrEqual(salary);

        // then
        assertThat(actualEmployeeDtos).isEqualTo(expectedEmployeeDtos);
    }

    @Test
    @DisplayName("Should get employees less than salary")
    void shouldGetEmployeesBySalaryLessThan() {
        // given
        double salary = 60000.0;
        List<Employee> employees = Arrays.asList(johnDoe);
        List<EmployeeDto> expectedEmployeeDtos = Arrays.asList(
                new EmployeeDto(1L, "John", new DepartmentDto(1L, "IT"), 50000.0)
        );

        when(employeeRepository.findBySalaryLessThan(salary)).thenReturn(employees);
        when(entityToDtoMapper.mapEmployeeToDTO(johnDoe)).thenReturn(expectedEmployeeDtos.get(0));

        // when
        List<EmployeeDto> actualEmployeeDtos = employeeService.getEmployeesBySalaryLessThan(salary);

        // then
        assertThat(actualEmployeeDtos).isEqualTo(expectedEmployeeDtos);
    }

    @Test
    @DisplayName("Should get employees greater than or equal by department and salary")
    void shouldGetEmployeesByDepartmentAndSalaryGreaterThanOrEqual() {
        // given
        String departmentName = "IT";
        double salary = 50000.0;
        List<Employee> employees = Arrays.asList(johnDoe);
        List<EmployeeDto> expectedEmployeeDtos = Arrays.asList(
                new EmployeeDto(1L, "John", new DepartmentDto(1L, "IT"), 50000.0)
        );

        when(employeeRepository.findByDepartmentAndSalaryGreaterThanOrEqual(departmentName, salary)).thenReturn(employees);
        when(entityToDtoMapper.mapEmployeeToDTO(johnDoe)).thenReturn(expectedEmployeeDtos.get(0));

        // when
        List<EmployeeDto> actualEmployeeDtos = employeeService.getEmployeesByDepartmentAndSalaryGreaterThanOrEqual(departmentName, salary);

        // then
        assertThat(actualEmployeeDtos).isEqualTo(expectedEmployeeDtos);
    }

    @Test
    @DisplayName("Should get employees less than or equal by department and salary")
    void shouldGetEmployeesByDepartmentAndSalaryLessThan() {
        // given
        String departmentName = "IT";
        double maxSalary = 60000.0;
        List<Employee> employees = Arrays.asList(johnDoe);
        List<EmployeeDto> expectedEmployeeDtos = Arrays.asList(
                new EmployeeDto(1L, "John", new DepartmentDto(1L, "IT"), 50000.0)
        );

        when(employeeRepository.findByDepartmentAndSalaryLessThan(departmentName, maxSalary)).thenReturn(employees);
        when(entityToDtoMapper.mapEmployeeToDTO(johnDoe)).thenReturn(expectedEmployeeDtos.get(0));

        // when
        List<EmployeeDto> actualEmployeeDtos = employeeService.getEmployeesByDepartmentAndSalaryLessThan(departmentName, maxSalary);

        // then
        assertThat(actualEmployeeDtos).isEqualTo(expectedEmployeeDtos);
    }
}
