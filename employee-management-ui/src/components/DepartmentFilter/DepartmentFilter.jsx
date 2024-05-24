import React, { useState } from 'react';
import './DepartmentFilter.css';

const DepartmentFilter = ({ onDepartmentChange }) => {
  const [department, setDepartment] = useState('');

  const handleInputChange = (e) => {
    const departmentName = e.target.value;
    setDepartment(departmentName);
    onDepartmentChange(departmentName);
  };

  return (
    <div className="department-filter">
      <label htmlFor="departmentFilter">Filter by Department:</label>
      <input
        id="departmentFilter"
        type="text"
        value={department}
        onChange={handleInputChange}
      />
    </div>
  );
};

export default DepartmentFilter;