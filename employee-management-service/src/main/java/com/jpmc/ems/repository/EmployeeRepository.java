package com.jpmc.ems.repository;

import com.jpmc.ems.domain.Department;
import com.jpmc.ems.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(Department department);
    List<Employee> findBySalaryGreaterThan(double salary);
}