import React, { useState } from 'react';
import './SalaryFilter.css';

const SalaryFilter = ({ onSalaryFilterChange }) => {
  const [salaryFilter, setSalaryFilter] = useState(null);

  const handleToggleChange = (e) => {
    const value = e.target.value === 'true' ? 10000 : null;
    setSalaryFilter(value);
    onSalaryFilterChange(value);
  };

  return (
    <div className="salary-filter">
      <label>
        <input
          type="radio"
          name="salaryFilter"
          value={false}
          checked={salaryFilter === null}
          onChange={handleToggleChange}
        />
        &lt; 10K
      </label>
      <label>
        <input
          type="radio"
          name="salaryFilter"
          value={true}
          checked={salaryFilter === 10000}
          onChange={handleToggleChange}
        />
        &gt; 10K
      </label>
    </div>
  );
};

export default SalaryFilter;