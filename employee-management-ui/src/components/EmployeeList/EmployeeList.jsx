import React, { useEffect, useState, useCallback } from 'react';
import employeeService from '../../services/employeeService';
import EmployeeFilter from '../../components/EmployeeFilter/EmployeeFilter';
import './EmployeeList.css';
import { debounce } from '../../utils/debounce';
import { handleErrorResponse } from '../../utils/errorHandler';

const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);
  const [filteredEmployees, setFilteredEmployees] = useState([]);
  const [filtersApplied, setFiltersApplied] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchEmployees = async () => {
      try {
        const employees = await employeeService.getAll();
        setEmployees(employees);
        setError(null); // Reset the error state
      } catch (error) {
        console.error('Error fetching employees:', error);
        setError(handleErrorResponse(error)); // Set the error state with the error response

      }
    };

    fetchEmployees();
  }, []);

  const debouncedHandleFilterChange = useCallback(
    debounce(async ({ department, salaryFilter }) => {
      try {
        let filtered = [];
  
        // 1. If the department is provided and the salary filter is null (less than 10K)
        if (department && salaryFilter === null) {
          // Fetch employees by department
          filtered = await employeeService.getByDepartment(department);
          // Filter employees with salary less than 10K
          filtered = filtered.filter((employee) => employee.salary < 10000);
        }
        // 2. If both the department and salary filter (greater than or equal to 10K) are provided
        else if (department && salaryFilter === 10000) {
          // Fetch employees by department and salary greater than or equal to 10K
          filtered = await employeeService.getByDepartmentAndSalaryGreaterThanOrEqual(department, salaryFilter);
        }
        // 3. If only the salary filter (greater than or equal to 10K) is provided
        else if (salaryFilter === 10000) {
          // Fetch employees with salary greater than or equal to 10K
          filtered = await employeeService.getEmployeesBySalaryGreaterThanOrEqual(salaryFilter);
        }
        // 4. If only the salary filter is null (less than 10K)
        else if (salaryFilter === null) {
          // Fetch employees with salary less than 10K
          filtered = await employeeService.getEmployeesBySalaryLessThan(10000);
        }
        // 5. If no filters are provided
        else {
          // Show all employees
          filtered = employees;
        }
  
        // Check if the department is invalid
        const isInvalidDepartment = filtered.length === 0 && department;
  
        setFiltersApplied(true);
        setFilteredEmployees(isInvalidDepartment ? [] : filtered);
        setError(isInvalidDepartment ? handleErrorResponse(new Error('Department not found')) : null);
      } catch (error) {
        console.error('Error filtering employees:', error);
        setError(handleErrorResponse(error));
      }
    }, 700),
    []
  );

  return (
    <div className="employee-list-container">
      <h1 className="project-name">Employee Management System</h1>
      {error && (
        <div className="error-message">
          <p className="no-employees-found">{error.message}</p>
        </div>
      )}
      <EmployeeFilter onFilterChange={debouncedHandleFilterChange} />
      {filtersApplied && filteredEmployees.length === 0 && !error ? (
        <p className="no-employees-found">No employees found.</p>
      ) : !filtersApplied ? (
        <p className="initial-message">Please apply filters to see employee data.</p>
      ) : error ? null : (
        <div>
          <h3>Filtered Employees</h3>
          <table className="employee-table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Department</th>
                <th>Salary</th>
              </tr>
            </thead>
            <tbody>
              {filteredEmployees.map((employee) => (
                <tr key={employee.id}>
                  <td>{employee.name}</td>
                  <td>{employee.department.name}</td>
                  <td>{employee.salary}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default EmployeeList;
