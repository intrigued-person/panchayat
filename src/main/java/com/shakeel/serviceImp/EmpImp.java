package com.shakeel.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakeel.model.Employee;
import com.shakeel.repos.EmpRepoImp;
import com.shakeel.service.EmpService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpImp implements EmpService {

	@Autowired
	EmpRepoImp dao;

	@Override
	public void addEmployee(Employee emp) {
		dao.addEmployee(emp);

	}

	@Override
	public List<Employee> getAllEmployee() {
		return dao.getAllEmployee();
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		return dao.updateEmployee(emp);
	}

	@Override
	public void deleteEmployee(int empId) {
		dao.deleteEmployee(empId);

	}

	@Override
	public Employee employeeLogin(String empName, String password) {
		Employee emp = null;
		try {
			emp = dao.employeeLogin(empName, password);
		} catch (Exception e) {
			emp = null;
		}

		return emp;
	}
}
