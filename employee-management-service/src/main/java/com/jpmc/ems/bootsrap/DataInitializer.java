package com.jpmc.ems.bootsrap;

import com.jpmc.ems.domain.Department;
import com.jpmc.ems.domain.Employee;
import com.jpmc.ems.repository.DepartmentRepository;
import com.jpmc.ems.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataInitializer(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Initialize departments
        Department engineering = departmentRepository.save(Department.builder().name("Engineering").build());
        Department sales = departmentRepository.save(Department.builder().name("Sales").build());
        Department marketing = departmentRepository.save(Department.builder().name("Marketing").build());

        // Initialize employees
        employeeRepository.saveAll(List.of(
                Employee.builder().name("John Doe").department(engineering).salary(5000.00).build(),
                Employee.builder().name("Jane Smith").department(engineering).salary(6000.00).build(),
                Employee.builder().name("Tom").department(engineering).salary(16000.00).build(),
                Employee.builder().name("Matt").department(engineering).salary(6000.00).build(),
                Employee.builder().name("Bob Johnson").department(sales).salary(4500.00).build(),
                Employee.builder().name("Chris").department(sales).salary(12500.00).build(),
                Employee.builder().name("Adam").department(sales).salary(14500.00).build(),
                Employee.builder().name("Alice Williams").department(marketing).salary(5500.00).build(),
                Employee.builder().name("Steve").department(marketing).salary(11000.00).build(),
                Employee.builder().name("Tim").department(marketing).salary(18000.00).build()
        ));
    }
}