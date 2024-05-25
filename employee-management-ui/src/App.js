import React, { useState } from 'react';
import EmployeeList from './components/EmployeeList/EmployeeList';
import './App.css';

const App = () => {
  const [department, setDepartment] = useState('');
  const [salaryFilter, setSalaryFilter] = useState(null);

  return (
    <div>
      <EmployeeList department={department} salaryFilter={salaryFilter} />
    </div>
  );
};

export default App;