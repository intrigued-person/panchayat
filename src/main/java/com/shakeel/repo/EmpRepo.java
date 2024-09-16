package com.shakeel.repo;

import java.util.List;

import com.shakeel.model.Employee;

public interface EmpRepo {

	public void addEmployee(Employee emp);

	public Employee employeeLogin(String empName, String password);

	public List<Employee> getAllEmployee();

	public boolean updateEmployee(Employee emp);

	public void deleteEmployee(int empId);

}
