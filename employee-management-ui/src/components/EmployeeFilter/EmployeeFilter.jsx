import React, { useState } from 'react';
import './EmployeeFilter.css';

const EmployeeFilter = ({ onFilterChange }) => {
  const [department, setDepartment] = useState('');
  const [salaryFilter, setSalaryFilter] = useState(null);

  const handleDepartmentChange = (e) => {
    setDepartment(e.target.value);
    onFilterChange({ department: e.target.value, salaryFilter });
  };

  const handleSalaryFilterChange = (value) => {
    setSalaryFilter(value);
    onFilterChange({ department, salaryFilter: value });
  };

  return (
    <div className="filter-container">
      <input
        type="text"
        placeholder="Enter department name"
        value={department}
        onChange={handleDepartmentChange}
        className="filter-input"
      />
      <div className="filter-buttons">
        <button
          className={`filter-button ${salaryFilter === null ? 'selected' : ''}`}
          onClick={() => handleSalaryFilterChange(null)}
        >
          &lt; 10K
        </button>
        <button
          className={`filter-button ${salaryFilter === 10000 ? 'selected' : ''}`}
          onClick={() => handleSalaryFilterChange(10000)}
        >
          &gt; 10K
        </button>
      </div>
    </div>
  );
};

export default EmployeeFilter;