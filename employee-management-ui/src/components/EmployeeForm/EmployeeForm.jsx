/* import React, { useState } from 'react';
import Button from '../common/Button';
import Input from '../common/Input';
import './EmployeeForm.css';

const EmployeeForm = () => {
  const [name, setName] = useState('');
  const [department, setDepartment] = useState('');
  const [salary, setSalary] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission logic here
    console.log('Name:', name);
    console.log('Department:', department);
    console.log('Salary:', salary);
  };

  return (
    <div className="employee-form">
      <h2>Add Employee</h2>
      <form onSubmit={handleSubmit}>
        <Input
          label="Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <Input
          label="Department"
          value={department}
          onChange={(e) => setDepartment(e.target.value)}
        />
        <Input
          label="Salary"
          type="number"
          value={salary}
          onChange={(e) => setSalary(e.target.value)}
        />
        <Button type="submit">Submit</Button>
      </form>
    </div>
  );
};

export default EmployeeForm; */