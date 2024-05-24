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

const getEmployeesBySalaryGreaterThan = async (salary) => {
  const response = await axios.get(`${baseUrl}/salary/${salary}`);
  return response.data;
};

export default { getAll, getByDepartment, getEmployeesBySalaryGreaterThan };