import React, { useEffect, useState } from 'react';
import employeeService from '../../services/employeeService';
import './EmployeeList.css';

const EmployeeList = ({ department, salaryFilter }) => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    const fetchEmployees = async () => {
      try {
        let employees;
        if (department) {
          employees = await employeeService.getByDepartment(department);
        } else if (salaryFilter) {
          employees = await employeeService.getEmployeesBySalaryGreaterThan(salaryFilter);
        } else {
          employees = await employeeService.getAll();
        }
        setEmployees(employees);
      } catch (error) {
        console.error('Error fetching employees:', error);
      }
    };

    fetchEmployees();
  }, [department, salaryFilter]);

  return (
    <div>
      <h2>Employee List</h2>
      <table className="employee-list">
        <thead>
          <tr>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.name}</td>
              <td>{employee.department.name}</td>
              <td>{employee.salary}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default EmployeeList;