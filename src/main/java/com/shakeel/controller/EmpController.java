package com.shakeel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakeel.model.Employee;
import com.shakeel.serviceImp.EmpImp;

@RestController
@RequestMapping("/emp")
@CrossOrigin("*")
public class EmpController {

	@Autowired
	EmpImp service;

	@PostMapping("/addEmp")
	public ResponseEntity<String> addStaff(@RequestBody Employee emp) {

		try {
			service.addEmployee(emp);

			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Failed");
		}

	}

	@GetMapping("/getAllEmps")
	public List<Employee> getAllEmps() {
		return service.getAllEmployee();

	}

	@GetMapping("/empLogin/{empName}/{password}")
	public ResponseEntity<?> empLogin(@PathVariable("empName") String empName,
			@PathVariable("password") String password) {

		try {
			Employee emp = service.employeeLogin(empName, password);
			if (emp != null) {
				return ResponseEntity.ok(emp);
			}
		} catch (Exception e) {
			System.out.println("Error while login");

		}

		return (ResponseEntity<?>) ResponseEntity.badRequest();

	}

	@PutMapping("/empUpdate")
	public ResponseEntity<String> empUpdate(@RequestBody Employee emp) {
		try {
			service.updateEmployee(emp);
			return ResponseEntity.ok("success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Fail");
		}
	}

	@DeleteMapping("deleteEmp/{empId}")
	public ResponseEntity<String> deleteEmp(@PathVariable("empId") int empId) {
		try {
			service.deleteEmployee(empId);
			return ResponseEntity.ok("success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Fail");
		}
	}

}
