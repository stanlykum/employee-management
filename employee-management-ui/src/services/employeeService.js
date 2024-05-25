import axios from 'axios';

const baseUrl = 'http://localhost:8801/api/employees';

const getAll = async () => {
  const response = await axios.get(`${baseUrl}/all`);
  return response.data;
};

const getByDepartment = async (departmentName) => {
  const response = await axios.get(`${baseUrl}/department/${departmentName}`);
  return response.data;
};

const getEmployeesBySalaryGreaterThanOrEqual = async (salary) => {
  const response = await axios.get(`${baseUrl}/salaryGreaterThanOrEqual/${salary}`);
  return response.data;
};

const getEmployeesBySalaryLessThan = async (salary) => {
  const response = await axios.get(`${baseUrl}/salaryLessThan/${salary}`);
  return response.data;
};

const getByDepartmentAndSalaryGreaterThanOrEqual = async (departmentName, salary) => {
  const response = await axios.get(`${baseUrl}/department/${departmentName}/salaryGreaterThanOrEqual/${salary}`);
  return response.data;
};

const getByDepartmentAndSalaryLessThan = async (departmentName, salary) => {
  const response = await axios.get(`${baseUrl}/department/${departmentName}/salaryLessThan/${salary}`);
  return response.data;
};

export default {
  getAll,
  getByDepartment,
  getEmployeesBySalaryGreaterThanOrEqual,
  getEmployeesBySalaryLessThan,
  getByDepartmentAndSalaryGreaterThanOrEqual,
  getByDepartmentAndSalaryLessThan,
};