package com.shakeel.service;

import java.util.List;

import com.shakeel.model.Employee;

public interface EmpService {

	public void addEmployee(Employee emp);

	public List<Employee> getAllEmployee();

	public boolean updateEmployee(Employee emp);

	public void deleteEmployee(int empId);

	public Employee employeeLogin(String empName, String password);

}
