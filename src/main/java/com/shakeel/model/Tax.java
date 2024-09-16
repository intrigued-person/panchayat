package com.shakeel.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Tax {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String newConnect;

	private String oldConnect;

	private String amount;

	private String type;

	private String status;

	private LocalDateTime generate;

	@ManyToOne
	private User user;

	@OneToOne
	private Payment payment;

	public Tax() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tax(int id, String newConnect, String oldConnect, String amount, String type, String status,
			LocalDateTime generate, User user, Payment payment) {
		super();
		this.id = id;
		this.newConnect = newConnect;
		this.oldConnect = oldConnect;
		this.amount = amount;
		this.type = type;
		this.status = status;
		this.generate = generate;
		this.user = user;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewConnect() {
		return newConnect;
	}

	public void setNewConnect(String newConnect) {
		this.newConnect = newConnect;
	}

	public String getOldConnect() {
		return oldConnect;
	}

	public void setOldConnect(String oldConnect) {
		this.oldConnect = oldConnect;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public LocalDateTime getGenerate() {
		return generate;
	}

	public void setGenerate(LocalDateTime generate) {
		this.generate = generate;
	}

}
