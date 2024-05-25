package com.jpmc.ems.repository;

import com.jpmc.ems.domain.Department;
import com.jpmc.ems.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(Department department);

    @Query("SELECT e FROM Employee e WHERE e.salary >= :salary")
    List<Employee> findBySalaryGreaterThanOrEqual(@Param("salary") double salary);

    @Query("SELECT e FROM Employee e WHERE e.salary < :salary")
    List<Employee> findBySalaryLessThan(@Param("salary") double salary);

    @Query("SELECT e FROM Employee e JOIN e.department d WHERE d.name = :departmentName AND e.salary >= :salary")
    List<Employee> findByDepartmentAndSalaryGreaterThanOrEqual(@Param("departmentName") String departmentName, @Param("salary") double salary);

    @Query("SELECT e FROM Employee e JOIN e.department d WHERE d.name = :departmentName AND e.salary < :salary")
    List<Employee> findByDepartmentAndSalaryLessThan(@Param("departmentName") String departmentName, @Param("salary") double salary);

}