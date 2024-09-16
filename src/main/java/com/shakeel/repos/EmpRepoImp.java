package com.shakeel.repos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shakeel.model.Employee;
import com.shakeel.repo.EmpRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@Repository
public class EmpRepoImp implements EmpRepo {

	@Autowired
	EntityManager em;

	@Override
	public void addEmployee(Employee emp) {
		em.persist(emp);
	}

	@Override
	public Employee employeeLogin(String empName, String password) {

		Query q = em.createQuery("from Employee log where log.empName =?1 and log.password=?2");
		q.setParameter(1, empName);
		q.setParameter(2, password);
		return (Employee) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		return em.createQuery("from Employee").getResultList();
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		em.merge(emp);
		return true;
	}

	@Override
	public void deleteEmployee(int empId) {
		Employee emp = em.find(Employee.class, empId);
		em.remove(emp);

	}

}
