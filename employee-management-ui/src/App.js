import React, { useState } from 'react';
import EmployeeList from './components/EmployeeList/EmployeeList';
import DepartmentFilter from './components/DepartmentFilter/DepartmentFilter';
import SalaryFilter from './components/SalaryFilter/SalaryFilter';
import './App.css';

const App = () => {
  const [department, setDepartment] = useState('');
  const [salaryFilter, setSalaryFilter] = useState(null);

  const handleDepartmentChange = (value) => {
    setDepartment(value);
    setSalaryFilter(null);
  };

  const handleSalaryFilterChange = (value) => {
    setSalaryFilter(value);
    setDepartment('');
  };

  return (
    <div>
      <DepartmentFilter onDepartmentChange={handleDepartmentChange} />
      <SalaryFilter onSalaryFilterChange={handleSalaryFilterChange} />
      <EmployeeList department={department} salaryFilter={salaryFilter} />
    </div>
  );
};

export default App;