	package com.shakeel.model;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	
	@Entity
	public class Employee {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int empId;
	
		private String empName;
	
		private String role;
	
		private long empMobile;
	
		private String password;
	
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
	
		public Employee(int empId, String empName, String role, long empMobile, String password) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.role = role;
			this.empMobile = empMobile;
			this.password = password;
		}
	
		public int getEmpId() {
			return empId;
		}
	
		public void setEmpId(int empId) {
			this.empId = empId;
		}
	
		public String getEmpName() {
			return empName;
		}
	
		public void setEmpName(String empName) {
			this.empName = empName;
		}
	
		public String getRole() {
			return role;
		}
	
		public void setRole(String role) {
			this.role = role;
		}
	
		public long getEmpMobile() {
			return empMobile;
		}
	
		public void setEmpMobile(long empMobile) {
			this.empMobile = empMobile;
		}
	
		public String getPassword() {
			return password;
		}
	
		public void setPassword(String password) {
			this.password = password;
		}
	
	}
